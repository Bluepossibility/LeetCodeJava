package Solutions.Design;

import java.util.HashSet;

public class Solution380 {
    private HashSet<Integer> hashSet;
    public Solution380() {
        this.hashSet = new HashSet<>();
    }

    public boolean insert(int val) {
        if (hashSet.contains(val)){
            return false;
        }
        else{
            hashSet.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (hashSet.contains(val)){
            hashSet.remove(val);
            return true;
        }
        else{
            revE
        }
    }

    public int getRandom() {

    }
}
