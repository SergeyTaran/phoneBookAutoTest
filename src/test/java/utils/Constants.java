package utils;

import com.github.javafaker.Faker;
import pages.ContactsPage;

import java.util.Random;

public class Constants {

    public static Faker faker = new Faker();


    public static Random random = new Random();
    public static String basicUrl = "http://dev.phonebook-1.telran-edu.de/";

//    ------------  EmailPage  ---------------

    public static String urlMailRu = "http://mail.ru/";
    public static String userMailRu = "sergeytaran82@mail.ua";
    public static String passMailRu = "QAtest82";

//    ------------------- ForgotPasswordPage --------------------------

    public static String forgotPassUrl = basicUrl + "user/forgot-password";
    public static String passRecoveryUrl = basicUrl + "user/password-recovery/";

//    ------------------  LoginPage  -------------------

    public static String userExisted = "qatest.taran01@gmail.com";
    public static String passwordExisted = "QAtest01";
    public static String wrongUser = System.currentTimeMillis() + ".tarangmail.com";
    public static String shortPass = "1234567";
    public static String longPass = "123456789012345678901";
    public static String loginUrl = basicUrl + "user/login";


//    ----------------  RegistrationPage  -------------------

    public static String newRandomUser = System.currentTimeMillis() + ".taran@gmail.com";
    public static String newRandomPass = "QAtest01";
    public static String registrationUrl = basicUrl + "user/registration";
    public static final String confirmRegUrl = basicUrl + "user/activate-email";

//  -----------------  APITests  -------------------------

    public static String basicAPIUrl = "http://dev.phonebook-1.telran-edu.de/api/";
    public static String loginAPIUrl = basicAPIUrl + "user/login";
    public static String passChangeAPIUrl = basicAPIUrl + "user/auth-password";
    public static String registrationAPIUrl = basicAPIUrl + "user";
    public static String passForgotAPIUrl = basicAPIUrl + "user/password/recovery";
    public static String passRenewAPIUrl = basicAPIUrl + "user/password";

//    -------------------  ContactsPage  ------------------------

    public static String contactsUrl = basicUrl + "contacts";
    public static String contactName = "user # " + System.currentTimeMillis();
    public static String contactAbout = "this contact created for testing";
    public static String fakerPhone = faker.phoneNumber().subscriberNumber();
    public static String contactPhone = random.nextInt(999999999)+"";

//    -------------------  PasswordPage  -------------------------

    public static String passwordPageUrl = basicUrl + "account/password";

//        -------------------  AddressesPage  -------------------------

    public static String AddressesPageUrl = basicUrl + "account/password";























}
