/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jeldis.model;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jorge.gonzalez
 */
public class PersonBeanModel {

    private String name = null;
    private String mail = null;
private List<String> messages;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    public void doSomething() {
        setName("[" + getName() + "]");
        setMail("[" + getMail() + "]");
    }

    public List<String> getMiLista() {
        this.messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        return this.messages;
    }
}
