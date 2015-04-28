#ifndef THIS_THINGER
#define THIS_THINGER

#include <iostream>
#include <cstdlib>
using namespace std;

template <typename Comparable>
class BTree
{
  public:
    BTree( ) : root(NULL) { 
    }

    BTree( const BTree & rhs ) : root(NULL) {
	makeEmpty();

	*this = rhs;
    }

    /**
     * Destructor for the tree
     */
    ~BTree( )
    {
        makeEmpty( );
    }

    const Comparable & findMin( ) const {
	return findMin(root)->element;
    }

    const Comparable & findMax( ) const {
	return findMax(root)->element;
    }

    bool contains( const Comparable & x ) const {
	return contains(x, root);
    }

    bool isEmpty( ) const {
	return root == NULL;
    }

    void printTree( ) const {
	printTree(root);
	cout << endl;
    } 

    void makeEmpty( ) {
	makeEmpty(root);
    }

    void insert( const Comparable & x ) {
	insert(x, root, NULL);
    }

    void remove( const Comparable & x ) {
	remove(x, root);
    }

    /**
     * Deep copy.
     */
    const BTree & operator=( const BTree & rhs )
    {
        if( this != &rhs )
        {
            makeEmpty( );
            root = clone( rhs.root );
        }
        return *this;
    }
    

  private:
    struct BinaryNode
    {
       Comparable element;
       BinaryNode *left;
       BinaryNode *right;
       BinaryNode* parent;

       BinaryNode( const Comparable & theElement, BinaryNode *lt, BinaryNode *rt, BinaryNode* pt )
         : element( theElement ), left( lt ), right( rt ), parent (pt) { }
    };

    BinaryNode *root;

    /**
     * Internal method to insert into a subtree.
     * x is the item to insert.
     * t is the node that roots the subtree.
     * Set the new root of the subtree.
     * (SJS) Note that this is not a const method
     */
    void insert( const Comparable & x, BinaryNode * & t, BinaryNode*& parent)
    {

        if( t == NULL ) 
            t = new BinaryNode( x, NULL, NULL, parent);
        else if( x < t->element )
            insert( x, t->left, t);
        else if( t->element < x )
            insert( x, t->right, t);
        else
            ;  // Duplicate; do nothing
    }
    /**
     * Internal method to remove from a subtree.
     * x is the item to remove.
     * t is the node that roots the subtree.
     * Set the new root of the subtree.
     * (SJS) Note this is not a const method
     * Book notes this is inefficient because of two
     * passes. Think about how you would correct this.
     */
    void remove( const Comparable & x, BinaryNode * & t )
    {
        if( t == NULL )
            return;   // Item not found; do nothing
        if( x < t->element )
            remove( x, t->left );
        else if( t->element < x )
            remove( x, t->right );
        else if( t->left != NULL && t->right != NULL ) // Two children
        {
            t->element = findMin( t->right )->element;
            remove( t->element, t->right );
        }
        else
        {
            BinaryNode *oldNode = t;
            if (t->left != NULL ) {
              t = t->left;
              t = oldNode->parent;
            } else {
              t = t->right;
              t = oldNode->parent;
            }
            delete oldNode;
        }
    }

    /**
     * Internal method to find the smallest item in a subtree t.
     * Return node containing the smallest item.
     */
    BinaryNode * findMin( BinaryNode *t ) const
    {
        if( t == NULL )
            return NULL;
        if( t->left == NULL )
            return t;
        return findMin( t->left );
    }

    /**
     * Internal method to find the largest item in a subtree t.
     * Return node containing the largest item.
     */
    BinaryNode * findMax( BinaryNode *t ) const
    {
        if( t != NULL )
            while( t->right != NULL )
                t = t->right;
        return t;
    }

    /**
     * Internal method to test if an item is in a subtree.
     * x is item to search for.
     * t is the node that roots the subtree.
     */
    bool contains( const Comparable & x, BinaryNode *t ) const
    {
        if( t == NULL )
            return false;
        else if( x < t->element )
            return contains( x, t->left );
        else if( t->element < x )
            return contains( x, t->right );
        else
            return true;    // Match
    }

    /**
     * Internal method to make subtree empty.
     */
    void makeEmpty( BinaryNode * & t )
    {
        if( t != NULL )
        {
            makeEmpty( t->left );
            makeEmpty( t->right );
            delete t;
        }
        t = NULL;
    }

    void printTree( BinaryNode *t ) const {
	// do an in-order traversal
	if (t == NULL)
		return;
	else {
		printTree(t->left);
		cout << t->element << ", ";
		printTree(t->right);
	}
    } 

    /**
     * Internal method to clone subtree.
     */
    BinaryNode * clone( BinaryNode *t ) const
    {
        if( t == NULL )
            return NULL;
 
        return new BinaryNode( t->element, clone( t->left ), clone( t->right ), clone( t->parent ));
    }
};

#endif
