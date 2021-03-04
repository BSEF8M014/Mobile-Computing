#include<iostream>
#include<fstream>
#include<string>
using namespace std;
class HashTable;
class Node
{
public:
	friend HashTable;
	string firstName;
	string lastName;
	Node* next;
	Node(string f, string n) :firstName(f), lastName(n), next(nullptr)
	{
	}
	bool operator==(const Node& n) const
	{
		return firstName == n.firstName && lastName == n.lastName;
	}
};

class LinkList 
{
private:
	friend HashTable;
	Node* head;
	int size;
public:
	LinkList()
	{
		head = nullptr;
		size = 0;
	}
	~LinkList()
	{
		while (head)
		{
			Node* ptr = head;
			head = head->next;
			delete ptr;
		}
	}
	bool isEmpty()
	{
		return head == nullptr;
	}
	bool find(Node name)
	{
		Node* ptr = head;
		while (ptr)
		{
			if (ptr->operator==(name))
			{
				return true;
			}
		}
		return false;
	}
	bool Insert(Node name)
	{
		Node* ptr = new Node(name);
		ptr->next = head;
		head = ptr;
		return true;
	}
	bool Delete(Node name)
	{
		Node* ptr = new Node("", "");
		Node* ptr1 = ptr;
		ptr->next = head;
		while (ptr->next)
		{
			if (ptr->next->operator == (name))
			{
				Node* temp = ptr->next;
				ptr->next = ptr->next->next;
				delete temp;
				delete ptr1;
				return true;
			}
		}
		return false;
	}
	void print(ofstream& fout)
	{
		Node* ptr = head;
		while (ptr)
		{
			fout << ptr->firstName << ", " << ptr->lastName << endl;
			ptr = ptr->next;
		}
	}
};
class HashTable
{
private:
	friend LinkList;
	LinkList* arr;
	int size;
	int noe;
public:
	HashTable(int s):size(s),noe(0)
	{
		arr = new LinkList[size];
	}
	int Doit(Node name)
	{
		int sum = 0;
		int i = 0;
		while (name.lastName[i])
		{
			sum += name.lastName[i];
		}
		return sum % size;
	}
	bool hashInsert(int index, string fn, string ln, ofstream& outFile2)
	{
		outFile2 << "*** Performing hashInsert on " << fn << ", " << ln << endl;

		if (findSpot(Doit(Node(fn,ln)),fn,ln))
		{
			outFile2 << "*** Warning, the record is already in the database!"<<endl;
		}
		else
		{
			arr[index].Insert(Node(fn, ln));
			printList(index, outFile2);
		}
	}
	void hashDelete(int index, string fn, string ln, ofstream& outFile2)
	{
		outFile2 << "*** Performing hashDelete on " << fn << ", " << ln << endl;

		if (!findSpot(Doit(Node(fn, ln)), fn, ln))
		{
			outFile2 << "*** Warning, the record doesn't exist in the database!" << endl;
		}
		else
		{
			arr[index].Delete(Node(fn, ln));
			printList(index, outFile2);
		}
	}
	bool find(Node n)
	{
		return arr[Doit(n)].Delete(n);
	}
	Node* findSpot(int index, string fn, string ln)
	{
		Node* spot = arr[index].head;
		while (spot->next != nullptr && !spot->next->operator==(Node(fn, ln)))
		{
			spot = spot->next;
		}
		return spot;
	}
	void hashRetrieval(int index, string fn, string ln, ofstream& fout)
	{
		fout<<"*** Performing hashRetrieval on "<<fn<<", "<<ln<<endl;
		if (findSpot(Doit(Node(fn, ln)), fn, ln))
		{
			fout << "Yes, the record is in the database!"<<endl;
		}
		else
		{
			fout << "No, the record is not in the database!" << endl;
		}
	}
	void printList(int index, ofstream& fout)
	{
		arr[index].print(fout);
	}
	void print(ofstream& fout)
	{
		for (int i = 0; i < size; i++)
		{
			printList(i, fout);
		}
	}
	~HashTable()
	{
		if (arr)
		{
			delete[] arr;
			size = 0;
			noe = 0;
			arr = nullptr;
			return;
		}
		size = 0;
		noe = 0;
		arr = nullptr;
	}
};

int main(int argc ,char**argv)
{
	ifstream fin(string(argv[1]));
	int size = stoi(string(argv[2]));
	ofstream outFile1(string(argv[3]));
	ofstream outFile2(string(argv[4]));
	HashTable hashTable(size);
	while (!fin.eof())
	{
		string op, fn, ln;
		fin >> op>> fn>> ln;
		Node name(fn, ln);
		if (op == "+")
		{
			hashTable.hashInsert(hashTable.Doit(name),name.firstName,name.lastName,outFile2);
		}
		else if (op == "-")
		{
			hashTable.hashDelete(hashTable.Doit(name), name.firstName, name.lastName, outFile2);
		}
		else
		{
			hashTable.hashRetrieval(hashTable.Doit(name), name.firstName, name.lastName, outFile2);
		}
	}
	hashTable.print(outFile1);
	fin.close();
	outFile1.close();
	outFile2.close();
	return 0;
}