#include <string>
#include <vector>
#include <sstream>
#include <map>

using namespace std;

map<string, string> ID;

vector<string> split(string str, char delimiter) {
    vector<string> internal;
    stringstream ss(str);
    string temp;
 
    while (getline(ss, temp, delimiter)) {
        internal.push_back(temp);
    }
 
    return internal;
}

vector<string> solution(vector<string> record) {
    vector<string> answer;
    int size = record.size();
    for (int i = 0; i < size; i++) {
        string s = record[i];
        vector<string> line_vector = split(s, ' ');
        
        if (line_vector[0] == "Enter") {
            if(ID.count(line_vector[1]) == 1) {
                ID.erase(line_vector[1]);
            }
            ID.insert(make_pair(line_vector[1], line_vector[2]));
        } else if (line_vector[0] == "Change") {
            ID.erase(line_vector[1]);
            ID.insert(make_pair(line_vector[1], line_vector[2]));
        }
    }

    for (int i = 0; i < size; i++) {
        string s = record[i];
        vector<string> line_vector = split(s, ' ');     
        if (line_vector[0] == "Enter") {
            string tmp = ID[line_vector[1]] + "님이 들어왔습니다.";
            answer.push_back(tmp);
        } else if (line_vector[0] == "Leave") {
            string tmp = ID[line_vector[1]] + "님이 나갔습니다.";
            answer.push_back(tmp);
        }
    }
    return answer;
}