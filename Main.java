package com.company;
import java.math.*;
import java.io.*;
import java.util.*;

public class Main {


    static BigInteger modExp(BigInteger n, BigInteger e, BigInteger mod_num) {
        BigInteger mod_of = BigInteger.valueOf(0);
        ArrayList<BigInteger> backwards_binary = new ArrayList<>();
        //Make base 2 number which is backwards so it starts at 2^0 for easy for loop
        while(e.intValue() != 0) {
            mod_of = e.mod(BigInteger.valueOf(2));
            e = e.divide(BigInteger.valueOf(2));
            backwards_binary.add(mod_of);

        }
        //Initialize modular exponentiation
        BigInteger x = BigInteger.valueOf(1);
        BigInteger power = n.mod(mod_num);
        BigInteger prev_num = power;
        //For Loop for modular exponentiation
        for(int i = 0; i < backwards_binary.size(); i++) {
            power = power.pow(2);
            if(backwards_binary.get(i).equals(BigInteger.valueOf(1))) {
                x = x.multiply(prev_num).mod(mod_num);

            }
            power = power.mod(mod_num);
            prev_num = power;
        }
        System.out.println("The answer is " + x.toString());
        return x;
    }


    public static void main(String[] args) {
	// write your code here
        BigInteger bigBase = new BigInteger("180632464247674");
        BigInteger bigExp = new BigInteger("189724091986154");
        BigInteger bigMod = new BigInteger("239839889869289");
        BigInteger answer = modExp(bigBase, bigExp, bigMod);+

    }

}
