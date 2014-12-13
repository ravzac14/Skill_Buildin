
@ECHO OFF
setlocal enableDelayedExpansion

REM Delete all teh user profiles (registry keys and c:\user\dirs) 
REM dir deletion is quick and dirty...leaves anything it doesn't have perms to delete
REM 

cd C:\Users

REM Grabs the free space in GB
df -h | head -n 2 | tail -n 1 | cut -d "G" -f3 > watwatdo.txt

FOR /F "tokens=*" %%F in (watwatdo.txt) do (
	set /a free=%%F
)

REM Set a var the necessary free space (> need = when NOT to run the script) 5GB is our minimum free space before we do the script
set need=5


REM Doesn't do it, but logs it
IF %free% GTR %need% (
	echo deleteUsers last run on %date% at %time%, no users deleted >> c:\temp\delUsers.log
)

REM Does it and logs it
IF %free% LEQ %need% (
	
	REM Pulls all the subkeys that are actual users (not system users which correlate to .*18.*,.*19.*, and .*20.*) from ProfileList into watdo.txt 
	reg query "HKLM\Software\Microsoft\Windows NT\CurrentVersion\ProfileList" | grep .*21.* > watdo.txt

	REM Deletes those profiles reg keys
	for /F "tokens=*" %%B in (watdo.txt) do (
		SET a=%%B
		SET meow=!a:HKEY_LOCAL_MACHINE=HKLM!
		reg delete "!meow!" /f
	)

	
	REM Pulls all the folder names except these to a text file for easier deletion
	dir /b | grep -v Default | grep -v Public | grep -v "All Users" | grep -v Administrator | grep -v desktop.ini | grep -v wat.txt > wat.txt

	REM Iterate through that text file and try to delete as a directory and a file
	for /F "tokens=*" %%A in (wat.txt) do (
		rd %%A /s /q 
	)

	REM Logs it
	echo deleteUsers last run on %date% at %time%, users were deleted >> c:\temp\delusers/log

	REM nuke the text files (requires wingnu or cygwin)
	rm -rf wat.txt
	rm -rf watwatdo.txt
	rm -rf watdo.txt
)