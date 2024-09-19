//package az.bron.business.config;
//
//import az.bron.business.feature.company.domain.model.Company;
//import az.bron.business.feature.company.domain.model.address.Address;
//import az.bron.business.feature.company.domain.model.contact.Contact;
//import az.bron.business.feature.company.domain.model.contact.Schedule;
//import az.bron.business.feature.company.domain.model.contact.Workday;
//import az.bron.business.feature.company.domain.model.contact.WorkingHours;
//import az.bron.business.feature.company.domain.repository.CompanyRepository;
//import az.bron.business.feature.master.domain.model.Master;
//import az.bron.business.feature.master.domain.repository.MasterRepository;
//import az.bron.business.feature.masterprovidedservice.domain.model.MasterProvidedService;
//import az.bron.business.feature.masterprovidedservice.domain.repository.MasterProvidedServiceRepository;
//import az.bron.business.feature.providedservice.domain.model.Duration;
//import az.bron.business.feature.providedservice.domain.model.ProvidedService;
//import az.bron.business.feature.providedservice.domain.repository.ProvidedServiceRepository;
//import az.bron.business.feature.servicecategory.domain.model.ServiceCategory;
//import az.bron.business.feature.servicecategory.domain.repository.ServiceCategoryRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalTime;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Configuration
//public class DataSeeder {
//
//    @Bean
//    public CommandLineRunner loadData(CompanyRepository companyRepository, ServiceCategoryRepository serviceCategoryRepository, MasterRepository masterRepository, MasterProvidedServiceRepository masterProvidedServiceRepository, ProvidedServiceRepository providedServiceRepository) {
//        return args -> {
//            // Define common working hours
//            WorkingHours workingHours = new WorkingHours();
//            workingHours.setStartTime(LocalTime.of(9, 0));
//            workingHours.setEndTime(LocalTime.of(17, 0));
//            workingHours.setBreakStartTime(LocalTime.of(12, 0));
//            workingHours.setBreakEndTime(LocalTime.of(13, 0));
//
//            Map<Workday, WorkingHours> scheduleMap = new HashMap<>();
//            for (Workday day : Workday.values()) {
//                scheduleMap.put(day, workingHours);
//            }
//
//            Schedule commonSchedule = new Schedule();
//            commonSchedule.setSchedule(scheduleMap);
//
//            // Define companies
//            Company company1 = createCompany("Tech Innovations Inc.", "A leading tech company specializing in innovative solutions.", "555-1234", "info@techinnovations.com", "https://www.techinnovations.com", "555-5678", "support@techinnovations.com", commonSchedule, 37.7749, -122.4194, "94103", "San Francisco", "CA", "123 Market St");
//
//            Company company2 = createCompany("Green Energy Solutions", "Innovative solutions for a sustainable future.", "555-2345", "contact@greenenergy.com", "https://www.greenenergy.com", "555-6789", "support@greenenergy.com", commonSchedule, 34.0522, -118.2437, "90001", "Los Angeles", "CA", "456 Elm St");
//
//            Company company3 = createCompany("HealthTech Labs", "Cutting-edge health technology and research.", "555-3456", "info@healthtechlabs.com", "https://www.healthtechlabs.com", "555-7890", "support@healthtechlabs.com", commonSchedule, 40.7128, -74.0060, "10001", "New York", "NY", "789 Broadway");
//
//            Company company4 = createCompany("FinTech Experts", "Revolutionizing finance with technology.", "555-4567", "contact@fintexperts.com", "https://www.fintexperts.com", "555-8901", "support@fintexperts.com", commonSchedule, 41.8781, -87.6298, "60601", "Chicago", "IL", "101 State St");
//
//            Company company5 = createCompany("EduTech Innovations", "Transforming education through technology.", "555-5678", "info@edutechinnovations.com", "https://www.edutechinnovations.com", "555-9012", "support@edutechinnovations.com", commonSchedule, 47.6062, -122.3321, "98101", "Seattle", "WA", "202 Pine St");
//
//            // Save to the database
//            companyRepository.saveAll(List.of(company1, company2, company3, company4, company5));
//
//            ServiceCategory cat1 = new ServiceCategory(null, "Consulting", "Professional consulting services.");
//            ServiceCategory cat2 = new ServiceCategory(null, "Development", "Software and app development services.");
//            ServiceCategory cat3 = new ServiceCategory(null, "Support", "Technical support and maintenance.");
//            ServiceCategory cat4 = new ServiceCategory(null, "Design", "Design and creative services.");
//            ServiceCategory cat5 = new ServiceCategory(null, "Training", "Training and educational services.");
//
//            // Save service categories
//            serviceCategoryRepository.saveAll(List.of(cat1, cat2, cat3, cat4, cat5));
//
//            // Define provided services
//            ProvidedService svc1 = new ProvidedService(null, "Tech Consulting", "Expert tech consulting services.", Duration.builder().hours(4).build(), company1, cat1, null);
//            ProvidedService svc2 = new ProvidedService(null, "App Development", "Custom app development services.", Duration.builder().hours(2).build(), company1, cat2, null);
//            ProvidedService svc3 = new ProvidedService(null, "Technical Support", "24/7 technical support.", Duration.builder().hours(1).build(), company1, cat3, null);
//            ProvidedService svc4 = new ProvidedService(null, "UI/UX Design", "Design services for user interfaces and experiences.", Duration.builder().hours(3).build(), company1, cat4, null);
//            ProvidedService svc5 = new ProvidedService(null, "Training Workshop", "Hands-on training workshops.", Duration.builder().hours(1).build(), company1, cat5, null);
//
////            ProvidedService svc1 = new ProvidedService(null, "Tech Consulting", "Expert tech consulting services.", Duration.builder().hours(4).build(), company3, cat1, null);
////            ProvidedService svc2 = new ProvidedService(null, "App Development", "Custom app development services.", Duration.builder().hours(2).build(), company3, cat2, null);
////            ProvidedService svc3 = new ProvidedService(null, "Technical Support", "24/7 technical support.", Duration.builder().hours(1).build(), company3, cat3, null);
////            ProvidedService svc4 = new ProvidedService(null, "UI/UX Design", "Design services for user interfaces and experiences.", Duration.builder().hours(3).build(), company3, cat4, null);
////            ProvidedService svc5 = new ProvidedService(null, "Training Workshop", "Hands-on training workshops.", Duration.builder().hours(1).build(), company3, cat5, null);
//            // Save provided services
//            providedServiceRepository.saveAll(List.of(svc1, svc2, svc3, svc4, svc5));
//
//            // Define masters
//            Master master1 = new Master(null, "Master Consultant", "Expert in tech solutions and consulting.", company1, null);
//            Master master2 = new Master(null, "Master Developer", "Specialist in software development.", company1, null);
//            Master master3 = new Master(null, "Master Designer", "Creative designer with a focus on UI/UX.", company1, null);
//            Master master4 = new Master(null, "Master Trainer", "Experienced in training and workshops.", company1, null);
//            Master master5 = new Master(null, "Master Support", "Proficient in providing technical support.", company1, null);
//
//            // Save masters
//            masterRepository.saveAll(List.of(master1, master2, master3, master4, master5));
//
//            // Define master provided services with different combinations
//            MasterProvidedService mps1 = new MasterProvidedService(null, master1, svc1, 200.00);
//            MasterProvidedService mps2 = new MasterProvidedService(null, master2, svc2, 5000.00);
//            MasterProvidedService mps3 = new MasterProvidedService(null, master3, svc4, 1500.00);
//            MasterProvidedService mps4 = new MasterProvidedService(null, master4, svc5, 1200.00);
//            MasterProvidedService mps5 = new MasterProvidedService(null, master5, svc3, 100.00);
//
//            // Save master provided services
//            masterProvidedServiceRepository.saveAll(List.of(mps1, mps2, mps3, mps4, mps5));
//
//        };
//    }
//
//    private Company createCompany(String name, String description, String phoneNumber, String email, String website, String additionalPhoneNumber, String additionalEmail, Schedule schedule, Double latitude, Double longitude, String postalCode, String city, String state, String street) {
//        Company company = new Company();
//        company.setName(name);
//        company.setDescription(description);
//
//        Address address = new Address();
//        address.setLatitude(latitude);
//        address.setLongitude(longitude);
//        address.setPostalCode(postalCode);
//        address.setCity(city);
//        address.setState(state);
//        address.setStreet(street);
//
//        Contact contact = new Contact();
//        contact.setPhoneNumber(phoneNumber);
//        contact.setEmail(email);
//        contact.setWebsite(website);
//        contact.setAdditionalPhoneNumber(additionalPhoneNumber);
//        contact.setAdditionalEmail(additionalEmail);
//        contact.setSchedule(schedule);
//        contact.setAddress(address);
//
//        company.setContact(contact);
//
//        return company;
//    }
//}
