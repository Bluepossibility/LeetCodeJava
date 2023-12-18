package Solutions.Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1436 {
    public String destCity(List<List<String>> paths) {
        // [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
        Set<String> startCities = new HashSet<>();
        for (List<String> path: paths) {
            String startCity = path.get(0);
            startCities.add(startCity);
        }
        for (List<String> path: paths){
            String endCity = path.get(1);
            if (!startCities.contains(endCity))
                return endCity;
        }
        return "";
    }
}
