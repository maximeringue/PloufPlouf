package com.example.demo.transientobj;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.List;

public class CoursWithUtil extends Cours {

    List<Utilisateur> lstUtil = new ArrayList<>();

    public void setLstUtil(List<Utilisateur> lstUtil) {
        this.lstUtil = lstUtil;
    }

    public List<Utilisateur> getLstUtil() {
        return lstUtil;
    }
}