/*
URL : https://leetcode.com/problems/employee-importance/submissions/

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int output = 0;
        Map<Integer,Employee> employeeMap = new HashMap<>();
        for(Employee emp : employees){
            employeeMap.put(emp.id,emp);
        }
        
        output = recur(id,employeeMap,output);
            
        return output;
    }
    
    public int recur(int id,Map<Integer,Employee> map,int output){
        if(map.containsKey(id)){
            output += map.get(id).importance;
            List<Integer> list = map.get(id).subordinates;
            if(!list.isEmpty()){
                for(Integer subEmp : list){
                    output = recur(subEmp,map,output);
                }
            }
        }
        return output;
    }
}