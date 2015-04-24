#ifndef MY_BINARY_TREE
#define MY_BINARY_TREE

#include <iostream>

template <typename Comparable>
class BTree 
{
  public:
    BTree () : root {nullptr} { }
    BTree (const BTree& rhs) : root {nullptr} { 
      makeEmpty();
      *this = rhs;
    }
    BTree (BTree&& rhs) : root {nullptr} { 
      makeEmpty();
      *this = std::move(rhs);
    }

    ~BTree ( ) { makeEmpty(); }

    const Comparable& findMin ( ) const { return findMin(root)->element; }
    const Comparable& findMax ( ) const { return findMax(root)->element; }
    bool contains (const Comparable& x) const { return contains(x,root); }
    bool isEmpty ( ) const { return root == nullptr; }

    void printTree (std::ostream& out = std::cout) const { 
      printTree(root,out); 
      out << std::endl;  
    }
    
    void makeEmpty ( ) { makeEmpty(root); }
    void insert (const Comparable& x) { insert(x,root); }
    void insert (Comparable&& x) { insert(std::move(x),root); }
    void remove (const Comparable& x) { remove(x,root);  }

    BTree& operator= (const BTree& rhs) 
    {
      if (this != &rhs) {
        makeEmpty();
        root = clone(rhs.root);
      }
      return *this;
    }
    BTree& operator= (BTree&& rhs) 
    {
      if (this != &rhs) {
        makeEmpty();
        root = clone(std::move(rhs.root));
      }
      return *this;
    }

  private:
    struct BNode 
    { 
      Comparable element;
      BNode* left;
      BNode* right;

      BNode (const Comparable& x, BNode* lt, BNode* rt) 
        : element {x}, left {lt}, right {rt} { }

      BNode (const Comparable&& x, BNode* lt, BNode* rt)
        : element {std::move(x)}, left {std::move(lt)}, right {std::move(rt)} { }
    };

    BNode* root;

    void insert (const Comparable& x, BNode*& t ) 
    {
      if (t == nullptr)
        t = new BNode {x,nullptr,nullptr};
      else if (x < t->element)
        insert(x,t->left);
      else if (x > t->element)
        insert(x,t->right);
      else
        ; // Duplicate node, do nothing
    }
    void insert (Comparable&& x, BNode*& t ) 
    {
      if (t == nullptr)
        t = new BNode {std::move(x),nullptr,nullptr};
      else if (x < t->element)
        insert(std::move(x),t->left);
      else if (x > t->element)
        insert(std::move(x),t->right);
      else
        ; // Duplicate node, do nothing
    }
    void remove (const Comparable& x, BNode*& t) 
    {
      if (t == nullptr) //Base case
        return;
      if (x < t->element) //left subtree
        remove(x,t->left);
      else if (x > t->element) //right subtree
        remove(x,t->right);
      else if (t->left != nullptr && t->right != nullptr) {//Has two children
        t->element = findMin(t->right)->element;
        remove(t->element,t->right);
      } else {
        BNode* oldNode = t;
        t = (t->left != nullptr) ? t->left : t->right;
        delete oldNode;
      }
    }
    BNode* findMin (BNode* t) const 
    {
      if (t != nullptr)
        while (t->left != nullptr)
          t = t->left;
      return t;
    }
    BNode* findMax (BNode* t) const 
    {
      if (t != nullptr)
        while (t->right != nullptr)
          t = t->right;
      return t;
    }
    bool contains (const Comparable& x, BNode* t) const 
    {
      if (t == nullptr) //base case
        return false;
      else if (x < t->element) //left tree
        return contains(x,t->left);
      else if (x > t->element) //right tree
        return contains(x,t->right);
      else
        return true; //current node
    }
    void makeEmpty (BNode*& t ) 
    {
      if (t != nullptr) 
      {
        makeEmpty(t->left);
        makeEmpty(t->right);
        delete t;
      }
      t = nullptr;
    }
    void printTree (BNode* t, std::ostream & out) const 
    {
      out << "[";
      if (t == nullptr) 
        out << "NULL";
      else 
        printTree(t->left,out);
        out << t->element << ",";
        printTree(t->right,out);
      out << "]";
    }
    BNode* clone (BNode* t) const 
    {
      if (t == nullptr)
        return nullptr;
      else
        return new BNode {t->element,clone(t->left),clone(t->right)};
    }
};

#endif
