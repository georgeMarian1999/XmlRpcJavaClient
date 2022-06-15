package org.main.client;

import com.google.gson.Gson;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.main.model.Author;
import org.main.model.Book;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {

    static XmlRpcClient proxy;
    static Gson gson = new Gson();

    static String path = "books.";


    public static XmlRpcClient getProxy() {
        if (proxy != null) {
            return proxy;
        }
        try {
            getNewConnection();
            return proxy;
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    public static void getNewConnection() throws MalformedURLException {

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();

        int port = 5050;

        String host = "localhost";


        URL urlServ = new URL("http://" + host + ":" + port);

        config.setServerURL(urlServ);

        proxy = new XmlRpcClient();
        proxy.setConfig(config);

    }

    public static String ping() {
        Object[] param = new Object[0];
        try {
            getNewConnection();
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return "Error with method ping " +  ex.getMessage();
        }
        try {
            return (String) proxy.execute(path + "ping", param);
        } catch (XmlRpcException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return "Error with method ping " + ex.getMessage();
        }

    }

    private static List<Author> getListFromJson(Object json) {
        System.out.println(json.toString());
        Author[] list = gson.fromJson(json.toString(), Author[].class);
        return new ArrayList<>(Arrays.asList(list));
    }

    private static List<Book> getListFromJsonBook(Object json) {
        System.out.println(json.toString());
        Book[] list = gson.fromJson(json.toString(), Book[].class);
        return new ArrayList<>(Arrays.asList(list));
    }

    public static List<Author> getAllAuthors()
    {
        Object[] param = new Object[0];
        try {
            getNewConnection();
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        try {
            List<Author> authors = getListFromJson(proxy.execute(path + "getAllAuthors", param));
            return authors;
        } catch (XmlRpcException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public static Author getAuthorById(int id)
    {
        Object[] param = new Object[] {
                id
        };
        try {
            getNewConnection();
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        try {

            return gson.fromJson((String) proxy.execute(path + "getAuthorById", param), Author.class);
        } catch (XmlRpcException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public static List<Author> getAuthorsBySearch(String keyword)
    {
        Object[] param = new Object[] {
                keyword
        };
        try {
            getNewConnection();
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        try {
            return getListFromJson(proxy.execute(path + "getAuthorsBySearch", param));
        } catch (XmlRpcException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public static void addAuthor(String name, int age)
    {
        Object[] param = new Object[] {
                name,
                age
        };
        try {
            getNewConnection();
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        try {
            proxy.execute(path + "addAuthor", param);
        } catch (XmlRpcException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

    }

    public static void deleteAuthor(int id)
    {
        Object[] param = new Object[] {
               id
        };
        try {
            getNewConnection();
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        try {
            proxy.execute(path + "deleteAuthor", param);
        } catch (XmlRpcException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void editAuthor(int id, String name, int age)
    {
        Object[] param = new Object[] {
                id,
                name,
                age
        };
        try {
            getNewConnection();
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        try {
            proxy.execute(path + "editAuthor", param);
        } catch (XmlRpcException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void addBook(String title, String description, Integer year, Integer authorId) {
        Object[] param = new Object[] {
                title,
                description,
                year,
                authorId
        };
        try {
            getNewConnection();
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        try {
            proxy.execute(path + "addBook", param);
        } catch (XmlRpcException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static List<Book> getBooksBySearch(String keyword) {
        Object[] param = new Object[] {
                keyword
        };
        try {
            getNewConnection();
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        try {
            return getListFromJsonBook(proxy.execute(path + "getBooksBySearch", param));
        } catch (XmlRpcException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public static List<Book> getAllBooks() {
        Object[] param = new Object[0];
        try {
            getNewConnection();
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        try {
            List<Book> books = getListFromJsonBook(proxy.execute(path + "getAllBooks", param));
            return books;
        } catch (XmlRpcException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public static Book getBookById(int bookId) {
        Object[] param = new Object[] {
                bookId
        };
        try {
            getNewConnection();
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        try {

            return gson.fromJson((String) proxy.execute(path + "getBookById", param), Book.class);
        } catch (XmlRpcException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public static void deleteBook(Integer id) {
        Object[] param = new Object[] {
                id
        };
        try {
            getNewConnection();
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        try {
            proxy.execute(path + "deleteBook", param);
        } catch (XmlRpcException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void editBook(Integer id, String title, String description, Integer year, Integer authorId) {
        Object[] param = new Object[] {
                id,
                title, description, year, authorId
        };
        try {
            getNewConnection();
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        try {
            proxy.execute(path + "editBook", param);
        } catch (XmlRpcException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
