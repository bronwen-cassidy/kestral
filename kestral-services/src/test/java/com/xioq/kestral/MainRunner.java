package com.xioq.kestral;

import javax.persistence.OneToMany;

/**
 * Created by bronwen.cassidy on 10/05/2015.
 */
public class MainRunner {

    public static void main(String[] args) {
        System.out.println(OneToMany.class.getProtectionDomain().getCodeSource().getLocation());

    }
}
