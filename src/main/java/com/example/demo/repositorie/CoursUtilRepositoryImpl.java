package com.example.demo.repositorie;

import com.example.demo.transientobj.Cours;
import com.example.demo.transientobj.CoursWithUtil;
import com.example.demo.transientobj.Utilisateur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoursUtilRepositoryImpl implements CoursUtilRepository {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected RestTemplate restTemplateCours;

    @Autowired
    protected RestTemplate restTemplateUtil;


    protected String serviceUrlCours;

    protected String serviceUrlUtil;

    public CoursUtilRepositoryImpl(String serviceUrlCours, String serviceUrlUtil) {
        this.serviceUrlCours = serviceUrlCours;
        this.serviceUrlUtil = serviceUrlUtil;
    }

    @Override
    public CoursWithUtil getCoursWithUtil(String idCours) {

        CoursWithUtil cwu = new CoursWithUtil();

        Cours c = restTemplateCours.getForObject(this.serviceUrlCours+"/cours/{id}",Cours.class,idCours);

        List<Utilisateur> lst = new ArrayList<>();
        for (String s: c.lstMembre) {

            lst.add(restTemplateUtil.getForObject(this.serviceUrlUtil+"/clients/{id}",Utilisateur.class,s));
        }





        cwu.setIdCours(c.idCours);
        cwu.setNom(c.nom);
        cwu.setLstUtil(lst);
        return cwu;
    }
}
