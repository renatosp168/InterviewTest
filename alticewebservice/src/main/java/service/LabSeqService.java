package service;

import service.interfaces.ILabSeqService;
import java.util.LinkedHashMap;
import java.util.Map;
import java.math.BigInteger;
public class LabSeqService  implements ILabSeqService {
    private final Map<Integer, BigInteger> cache;
    public LabSeqService(){
        int cacheSize = 100;
        cache = new LinkedHashMap<>(cacheSize);
    }
    public BigInteger calculateSequence(int index){
        if(index < 0 ) {
            return BigInteger.valueOf(-1);
        }

        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        BigInteger result;
        if (index < 4) {
            return BigInteger.valueOf(index % 2);
        } else {
            result = calculateSequence(index - 4).add(calculateSequence(index-3));
        }

        cache.put(index, result);
        return result;
    }
}
