/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.ear.ejb;

import javax.ejb.Stateful;
import java.net.*;
import java.io.*;

/**
 * A simple Hello World EJB. The EJB does not use an interface.
 *
 * @author paul.robinson@redhat.com, 2011-12-21
 */
@Stateful
public class GreeterEJB {
    /**
     * This method takes a name and returns a personalised greeting.
     *
     * @param name
     *            the name of the person to be greeted
     * @return the personalised greeting.
     */
    public String sayHello(String name) {
        return "Hello " + name;
    }
    
    public String sayJsonPosts(String user_id) {
        String urlString = "";
        try {
         URL url = new URL("http://jsonplaceholder.typicode.com/posts/" + user_id);
         URLConnection urlConnection = url.openConnection();
         HttpURLConnection connection = null;
         if(urlConnection instanceof HttpURLConnection) {
            connection = (HttpURLConnection) urlConnection;
         }else {
            
            return "resource not found....";
         }
         
         BufferedReader in = new BufferedReader(
            new InputStreamReader(connection.getInputStream()));
         urlString = "";
         String current;
         
         while((current = in.readLine()) != null) {
            urlString += current;
         }
         System.out.println(urlString);
            
      } catch (IOException e) {
         e.printStackTrace();
      }
      return urlString;
    }
}
