#include <stack>

class Solution {
public:
    bool isValid(string s) 
    {
        std::stack<char> stack;
        int size = s.size();
        for (int i=0; i<size; i++)
        {
            char c = s.at(i);
            switch (c)
            {
                case '(' :
                case '{' :
                case '[' :
                    stack.push(c);
                    break;
                case ')' :
                    if (stack.empty() or stack.top() != '(')
                        return false;
                    stack.pop();
                    break;
                case '}' :
                    if (stack.empty() or stack.top() != '{')
                        return false;
                    stack.pop();
                    break;
                case ']' :
                    if (stack.empty() or stack.top() != '[')
                        return false;
                    stack.pop();
            }
        }    
        return stack.empty();
    }
};