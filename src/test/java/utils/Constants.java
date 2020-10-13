package utils;

import pages.ContactsPage;

public class Constants {

//    ------------  EmailPage  ---------------

    public static String urlMailRu = "http://mail.ru/";
    public static String userMailRu = "sergeytaran82@mail.ua";
    public static String passMailRu = "QAtest82";

//    ------------------- ForgotPasswordPage --------------------------

    public static String forgotPassUrl = "http://dev.phonebook-1.telran-edu.de/user/forgot-password";

//    ------------------  LoginPage  -------------------

    public static String basicUrl = "http://dev.phonebook-1.telran-edu.de/";
    public static String userExisted = "qatest.taran01@gmail.com";
    public static String passwordExisted = "QAtest01";
    public static String wrongUser = System.currentTimeMillis() + ".tarangmail.com";
    public static String shortPass = "1234567";
    public static String longPass = "123456789012345678901";
    public static String loginUrl = "http://dev.phonebook-1.telran-edu.de/user/login";


//    ----------------  RegistrationPage  -------------------

    public static String newRandomUser = System.currentTimeMillis() + ".taran@gmail.com";
    public static String newRandomPass = "QAtest01";
    public static String registrationUrl = "http://dev.phonebook-1.telran-edu.de/user/registration";
    public static final String confirmRegUrl = "http://dev.phonebook-1.telran-edu.de/user/activate-email";

//  -----------------  APITests  -------------------------

    public static String basicAPIUrl = "http://dev.phonebook-1.telran-edu.de/api/";
    public static String loginAPIUrl = basicAPIUrl + "user/login";
    public static String passChangeAPIUrl = basicAPIUrl + "user/auth-password";
    public static String registrationAPIUrl = basicAPIUrl + "user";
    public static String passForgotAPIUrl = basicAPIUrl + "user/password/recovery";
    public static String passRenewAPIUrl = basicAPIUrl + "user/password";

//    -------------------  ContactsPage  ------------------------
    public static String contactsUrl = "http://dev.phonebook-1.telran-edu.de/contacts";
    public static String contactName = "user # " + System.currentTimeMillis();
    public static String contactAbout = "this contact created for testing";
//    public static String contactPhone = System.currentTimeMillis()+"".split("41", 2)[1];
    public static String contactPhone = (int) (Math.random()*(1111111111+1)) + 200 +"";


















}
