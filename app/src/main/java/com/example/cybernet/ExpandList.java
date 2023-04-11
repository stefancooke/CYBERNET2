package com.example.cybernet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandList {
    public static HashMap<String , List<String >> getData(){
        HashMap<String, List<String >> expandListDetail= new HashMap<String, List<String>>();

        List<String > Topic1=new ArrayList<String>();
        Topic1.add("Phishing is a cybercrime in which a target or targets are contacted by email, telephone or text message by someone posing as a legitimate institution to lure individuals into providing sensitive data such as personally identifiable information, banking and credit card details, and passwords.");


        List<String > Topic2=new ArrayList<String>();
        Topic2.add(" Spear phishing is an email scam targeted towards an individual, a business, or an organization to steal personal data such as financial information or account credentials to trick the person into believing they have a real-world connection to the sender.");


        List<String > Topic3=new ArrayList<String>();
        Topic3.add("Whaling is similar to spear phishing, except on a much larger scale. These emails usually have a subject line about a \"critical\" business manner and are sent to someone high-up in the food chain within a specific business or organization. The objective of whaling attacks is to infect a computer with malware and obtain executives' business email credentials to make fraudulent wire transfers.");

        List<String > Topic4=new ArrayList<String>();
        Topic4.add("When a whaling attack is successful, CEO fraud occurs. Attackers successfully impersonate and abuse the CEO's email to approve wire transfers to a financial institution of their choice.");


        List<String > Topic5=new ArrayList<String>();
        Topic5.add("This method stems from a domain name system (DNS) cache manipulating. The internet uses DNS servers to convert website names to numeric IP addresses. The attacker then targets the DNS server and changes the IP address, allowing the attacker to redirect users to a malicious website, even if they type in the correct URL.");


        List<String > Topic6=new ArrayList<String>();
        Topic6.add(" Also known as vishing, this is a form of phishing over voice communication media. Using speech synthesis software, an attacker will leave a voicemail notifying the victim of suspicious activity on their bank account or credit account and urges the victim to respond to verify their identity. This leads to identity theft, after which scammers use compromised credit card numbers for their malicious purposes.");


        List<String > Topic7=new ArrayList<String>();
        Topic7.add("Social Engineering is the use of deception to manipulate individuals into divulging confidential or personal information that may be used for fraudulent purposes. ");

        List<String > Topic8=new ArrayList<String>();
        Topic8.add("A Malicious Page is a page which is designed to look like a legitimate website. However it is a page designed by an attacker and they attempt to get the user to enter their private information into the fake website.");


        List<String > Topic9=new ArrayList<String>();
        Topic9.add("Simulated phishing or a phishing test is where deceptive emails, similar to malicious emails, are sent by an organization to their own staff to gauge their response to phishing and similar email attacks. The emails themselves are often a form of training, but such testing is normally done in conjunction with prior training; and often followed up with more training elements. This is especially the case for those who \"fail\" by opening email attachments, clicking on included weblinks, or entering credentials.");

        List<String > Topic10=new ArrayList<String>();
        Topic10.add("Spoofing is when someone disguises an email address, sender name, phone number, or website URL—often just by changing one letter, symbol, or number—to convince you that you are interacting with a trusted source.\n" +
                "\n" +
                "For example, you might receive an email that looks like it’s from your boss, a company you’ve done business with, or even from someone in your family—but it actually isn’t.");


        List<String > Topic11=new ArrayList<String>();
        Topic11.add("a URL is the address of a webpage. Some examples are https://google.com, https://youtube.com and https://ebay.com");

        List<String > Topic12=new ArrayList<String>();
        Topic12.add("A Firewall is a network security system that monitors and controls incoming and outgoing network traffic based on predetermined security rules. A firewall typically establishes a barrier between a trusted network and an untrusted network, such as the Internet.");

        List<String > Topic13=new ArrayList<String>();
        Topic13.add("Anti-Virus Software is Antivirus software (abbreviated to AV software), also known as anti-malware, is a computer program used to prevent, detect, and remove malware.\n" +
                "\n" +
                "Antivirus software was originally developed to detect and remove computer viruses, hence the name. However, with the proliferation of other malware, antivirus software started to protect against other computer threats. Some products also include protection from malicious URLs, spam, and phishing.");









        expandListDetail.put("Phishing", Topic1);
        expandListDetail.put("Spear Phishing", Topic2);
        expandListDetail.put("Whaling", Topic3);
        expandListDetail.put("CEO Fraud", Topic4);
        expandListDetail.put("Pharming", Topic5);
        expandListDetail.put("Voice Phishing", Topic6);
        expandListDetail.put("Social Engineering", Topic7);
        expandListDetail.put("Malicious Page", Topic8);
        expandListDetail.put("Simulated Phishing", Topic9);
        expandListDetail.put("Spoofing", Topic10);
        expandListDetail.put("URLs", Topic11);
        expandListDetail.put("Firewalls", Topic12);
        expandListDetail.put("Anti-Virus Software", Topic13);







        return expandListDetail;

    }


}
