public class IsUnique {
    public boolean isUnique(int[] intArray){
        for(int i = 0; i < intArray.length; i++){
            for(int j= 0; j < intArray.length; j++){
                if(intArray[i] == intArray[j]){
                    return false;
                }
            }
        }

        return true;
    }
}
