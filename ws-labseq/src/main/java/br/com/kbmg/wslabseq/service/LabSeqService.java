package br.com.kbmg.wslabseq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Service
@Slf4j
public class LabSeqService {

    private final SortedMap<Integer, BigInteger> mapControl;

    public LabSeqService() {
        this.mapControl = new TreeMap<>();
        BigInteger zeroBig = BigInteger.valueOf(0);
        BigInteger oneBig = BigInteger.valueOf(1);
        this.mapControl.putAll(Map.of(0, zeroBig, 1, oneBig, 2, zeroBig, 3, oneBig));
    }

    public BigInteger getResultValue(Integer valueToCalculate) {
        segregateIfIsBigNumberToControlMemory(valueToCalculate);
        return calculate(valueToCalculate);
    }

    private void segregateIfIsBigNumberToControlMemory(Integer valueToCalculate) {
        Integer lastKey = mapControl.lastKey();
        int diffBetweenValueAndLastKey = valueToCalculate - lastKey;
        if(diffBetweenValueAndLastKey > 5000) {
            for (int i = lastKey; i <= valueToCalculate; i += 5000) {
                calculate(i);
            }
        }
    }

    private BigInteger calculate(Integer valueToCalculate) {
        if (mapControl.containsKey(valueToCalculate)) {
            return mapControl.get(valueToCalculate);
        }

        BigInteger result = getResultValue(valueToCalculate - 4).add(getResultValue(valueToCalculate - 3));

        mapControl.put(valueToCalculate, result);

        return result;
    }

}
