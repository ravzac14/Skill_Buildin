'%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
'Script to check free disk space and if near full: remove all User profiles other than the current and the default/public/admin ones.%%
'ONLY WORKS WITH WIN7 and OLDER os's																								 %%
'SHOULD Also nukes the dirs from C:/Users as it goes BUT DOESNT BECAUSE vbs IS NOT SMART ENOUGH										 %%
'so INSTEAD it runs a .bat script at the end to delete the user dirs																 %%
'																																	 %%
'ALSO FUNCTIONALLY WORKS TO NUKE THE USERS FROM REG FOR THE OPEN ACCESS MACHINES													 %%
'																																	 %%
'tc_zack 10/28/14																													 %%
'%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


'Initiate custom error handling
On Error Resume Next


'Allot space in memory for teh objects
Dim objFSO, objWMIService, strComputer, objProfile, strKeyPath, strSubPath, strValueName, strValue, objFile, objLogicalDisk
Dim arrSubKeys, fsInGB, RE, shell


'Make FSObject and log file
Set objFSO = CreateObject("Scripting.FileSystemObject")
Set objFile = objFSO.CreateTextFile("C:\temp\userss.log", True)
objFile.WriteLine "from ev-deleteUserProfiles; Checks diskspace and then reports all the user files it sees and if/who it deletes:"
objFile.WriteLine "Last run: " & Date & ", At: " & Time

'Make Shell object to run the ev-deleteUserDirs.bat script near the end of this file
set shell = CreateObject("wscript.shell")

'Set vars for wmiobj and disk obj..then reports the disk space
Set objWMIService = GetObject("winmgmts:")
Set objLogicalDisk = objWMIService.Get("Win32_LogicalDisk.DeviceID='c:'")
fsInGB = objLogicalDisk.FreeSpace / 1000000000			'FreeSpace returns a 64bitInt representing free space in bytes 1GB = 1bil bytes
objFile.WriteLine "Free disk space on c: " & fsInGB		


'Set vars for registy and specifically profilelist 
strComputer = "."					' . means local computer
Const HKEY_LOCAL_MACHINE = &H80000002
Set objRegistry = GetObject("winmgmts:{impersonationLevel=impersonate}!\\" & strComputer & "\root\default:StdRegProv")

strKeyPath = "SOFTWARE\Microsoft\Windows NT\CurrentVersion\ProfileList"

'%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
'Uncomment the following line for testing...OR FOR LIB OPEN ACCESS MACHINES      %%
'LIB OPEN ACCESS MACHINES NEED USERS DELETED EVERYTIME SO AS NOT TO RECREATE THEM%%
'Forces the deletion of profiles despite the actual space on disk available		 %%
'%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
'fsInGB = 1.00


'First call of the recursive method DeleteSubKeys, ONLY IF FreeSpace is < 5GB ... according to Dylan for big files
If (fsInGB < 5.00) Then
	DeleteSubKeys HKEY_LOCAL_MACHINE, strKeyPath, objRegistry
Else
	objFile.WriteLine "Plenty of disk space free, no users deleted"
End If





'Sub function DeleteSubKeys goes through registry directories recursively starting from (and ignoring) Software...ProfileList
Sub DeleteSubKeys(HKEY_LOCAL_MACHINE, strKeyARG, objRegistry)
	'takes all the subdirs in that ^ path and puts them in an array "arrSubKeys"
	objRegistry.EnumKey HKEY_LOCAL_MACHINE, strKeyARG, arrSubKeys

	'Stops it once it hits the bottom
	If IsArray(arrSubKeys) Then
	
		'Iterates through arrSubKeys and does SOMETHING	
		For Each subKey in arrSubKeys
			strValueName = "ProfileImagePath"
			strSubPath = strKeyARG & "\" & subKey
			Return = objRegistry.GetExpandedStringValue(HKEY_LOCAL_MACHINE,strSubPath,strValueName,strValue)
		
			'not (Return = 0) Or 
			'Makes sure it's not looking at DEFAULT USERS: Default, admin, Public, Administrator, REGUSERS: C:\Windows\ServiceProfiles\NetworkService, C:\Windows\system32\config\systemprofile, C:\Windows\ServiceProfiles\LocalService
			If (not((StrComp(strValue,"C:\Users\Default",1) = 0) Or (StrComp(strValue,"C:\Users\admin",1) = 0) Or (StrComp(strValue,"C:\Users\Public",1) = 0) Or (StrComp(strValue,"C:\Users\Administrator",1) = 0) Or (StrComp(strValue,"C:\Windows\system32\config\systemprofile",1) = 0) Or (StrComp(strValue,"C:\Windows\ServiceProfiles\LocalService",1) = 0) Or (StrComp(strValue,"C:\Windows\ServiceProfiles\NetworkService",1) = 0))) Then

				
				'Recursive call of DeleteSubKey
				DeleteSubKeys HKEY_LOCAL_MACHINE, strSubPath, objRegistry

				
				Err.Clear
		
				objFile.WriteLine strSubPath
				'%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
				'Default is HKEY_LOCAL_MACHINE, Uncomment the next line when you want to ACTUALLY DELETE REG KEYS (after testing)%%
				'%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
				objRegistry.DeleteKey HKEY_LOCAL_MACHINE, strSubPath
		
				'Handlin' error$$$
				If Err.Number = -2147024809 Then
					objFile.WriteLine strSubPath & ": Profile in use, skipping"
				ElseIf Err.Number = -2147024751 Then
					objFSO.DeleteFolder subKey.LocalPath, True
					objFile.WriteLine strSubPath & ": Error: " & Str(Err.Number) & ": " & Err.Description
				ElseIf Err.Number <> 0 Then
					objFile.WriteLine strSubPath & ": Error: " & Str(Err.Number) & ": " & Err.Description
				ElseIF Err.Number = 0	Then
					objFile.WriteLine strSubPath & ": Profile Deleted"
				End If
			End If
		Next 'End for
	End If

	'Don't want to delete the users root folder (it would error anyway, but just to be safe) THIS ONE DELETES THE BOTTOMMOST FILES
	If not(StrComp(strKeyARG,"SOFTWARE\Microsoft\Windows NT\CurrentVersion\ProfileList",1) = 0) Then
		
		Err.Clear
		
		objFile.WriteLine strKeyArg
		'%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		'Default is HKEY_LOCAL_MACHINE, Uncomment the next line when you want to ACTUALLY DELETE REG KEYS (after testing)%%
		'%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		objRegistry.DeleteKey HKEY_LOCAL_MACHINE, strKeyArg
		
		'Handlin' error$$$
		If Err.Number = -2147024809 Then
			objFile.WriteLine strKeyARG & ": Profile in use, skipping"
		ElseIf Err.Number = -2147024751 Then
			objFSO.DeleteFolder subKey.LocalPath, True
			objFile.WriteLine strKeyARG & ": Error: " & Str(Err.Number) & ": " & Err.Description
		ElseIf Err.Number <> 0 Then
			objFile.WriteLine strKeyARG & ": Error: " & Str(Err.Number) & ": " & Err.Description
		ElseIF Err.Number = 0	Then
			objFile.WriteLine strKeyARG & ": Profile Deleted"
		End If
	End If

End Sub 'End DeleteSubKeys

'%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
'Delete them user dirs																					%%
'The string in run is the path to the batch script file													%%
'%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
shell.run "ev-deleteUserDirs.bat"

set shell = nothing 	'Close the shell
objFile.Close	'Gotta close teh stream