package com.spring.catfacts2.models;

import java.util.Date;

public class CatFacts implements Comparable <CatFacts> {

        private String text;
        private Date createdAt;

        public String getText(){
            return text;
        }
        public void setText (String text){
            this.text=text;
        }
        public Date getCreatedAt(){
            return createdAt;
        }
        public void setCreatedAt(Date createdAt){
            this.createdAt=createdAt;
        }
        public String toString(){
            return text + " - Created at: " + createdAt;
        }

    @Override
    public int compareTo(CatFacts other) {
        if(this.createdAt.before(other.createdAt))
        {
            return -1;
        }
        if(this.createdAt.after(other.createdAt))
        {
            return 1;
        }
        return 0;
    }
}
