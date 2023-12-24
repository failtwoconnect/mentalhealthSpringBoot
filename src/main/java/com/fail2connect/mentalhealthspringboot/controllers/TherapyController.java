package com.fail2connect.mentalhealthspringboot.controllers;

import com.fail2connect.mentalhealthspringboot.Service.ClientService;
import com.fail2connect.mentalhealthspringboot.Service.NumberService;
import com.fail2connect.mentalhealthspringboot.models.Client;
import com.fail2connect.mentalhealthspringboot.models.TherapyNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * Controller class for managing therapy-related operations.
 */
@Controller
@RequestMapping("/therapy")
public class TherapyController {
    private final NumberService numberService;
    private final ClientService clientService;
    @Autowired
    public TherapyController(NumberService numberService, ClientService clientService){
        this.numberService = numberService;
        this.clientService = clientService;
    }

    /**
     * Retrieves therapy numbers for a given client ID.
     *
     * @param model the Spring MVC model
     * @param id the client ID
     * @return the view name to render
     */
    @GetMapping("/numbers")
    public String getTherapyNumbers(Model model, @RequestParam("id") int id){
        List<TherapyNumber> numbers = numberService.findAllByClientId(id);
        model.addAttribute("TherapyNumber", numbers);
        model.addAttribute("clientID", id);
        return "therapy/numbers-detail";
    }

    /**
     * Saves a TherapyNumber object with the associated client ID.
     *
     * @param therapyNumber the TherapyNumber object to be saved
     * @param id the client ID associated with the TherapyNumber
     * @param redirectAttributes the RedirectAttributes object for redirecting to the therapy numbers page
     * @return the redirect view name
     */
    @PostMapping("/save")
    public String saveTherapyNumbers(@ModelAttribute("therapyNumber") TherapyNumber therapyNumber,
                                     @RequestParam("clientID") int id,
                                     RedirectAttributes redirectAttributes){
        Client client = clientService.findByID(id);
        therapyNumber.setClient(client);
        numberService.save(therapyNumber);
        redirectAttributes.addAttribute("id",id);
        return"redirect:/therapy/numbers";
    }

    /**
     * Shows the form for entering therapy numbers for a specific client.
     *
     * @param model the Spring MVC model
     * @param id the client ID
     * @return the view name for the therapy numbers form
     */
    @GetMapping("/showNumbersForm")
    public String showNumbersForm(Model model, @RequestParam("id") int id){
        Client client = clientService.findByID(id);
        TherapyNumber number = new TherapyNumber();
        number.setClient(client);
        model.addAttribute("clientID", client.getClientID());
        model.addAttribute("therapyNumber", number);
        return "/therapy/numbers-form";
    }

    /**
     * Retrieves data for the seven-day report of the therapy dashboard.
     *
     * @param model the Spring MVC model
     * @param id the client ID
     * @return the view name to render
     */
    @GetMapping("/dashboard/sevendayreport")
    public String showDashboard(Model model, @RequestParam("id") int id){
        String sevenDaysAgoString = LocalDate.now().minusDays(7).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String nowDateString =LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<String> dateLabels = numberService.findDatetimeLabels(sevenDaysAgoString,nowDateString,id);
        List<Integer> anxietyScoreBuckets = numberService.findAnxietyNumberBydatetime(sevenDaysAgoString,nowDateString,id);
        List<Integer> depressionScoreBuckets = numberService.findDepressionBuckets(sevenDaysAgoString,nowDateString,id);
        List<Integer> energyLevelBuckets = numberService.findEnergyLevelBuckets(sevenDaysAgoString,nowDateString,id);
        List<Integer> cravingLevelBuckets = numberService.findCravingBuckets(sevenDaysAgoString,nowDateString,id);
        List<Integer> selfHarmLevelBuckets = numberService.findSelfHarmBuckets(sevenDaysAgoString,nowDateString,id);
        List<Integer> impulseLevelBuckets = numberService.findImpulseBuckets(sevenDaysAgoString,nowDateString,id);
        model.addAttribute("labels",dateLabels);
        model.addAttribute("anxietyData", anxietyScoreBuckets);
        model.addAttribute("depressionData", depressionScoreBuckets);
        model.addAttribute("energyLevelData", energyLevelBuckets);
        model.addAttribute("cravingLevelData", cravingLevelBuckets);
        model.addAttribute("selfHarmLevelData", selfHarmLevelBuckets);
        model.addAttribute("impulseLevelData", impulseLevelBuckets);
        model.addAttribute("id", id);
        return "/therapy/numbers-metric-seven-day-reports";
    }

    /**
     * Shows the form for updating a TherapyNumber for a specific client.
     *
     * @param numberId   the ID of the TherapyNumber to update
     * @param client_id  the ID of the client associated with the TherapyNumber
     * @param model      the Spring MVC model
     * @return the view name for the therapy numbers form
     */
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("numberId") int numberId,
                                    @RequestParam("clientId") int client_id,
                                    Model model){
        TherapyNumber number = numberService.findTherapyNumberByNumberId(numberId);
        model.addAttribute("therapyNumber", number);
        model.addAttribute("clientID",client_id);
        return "therapy/numbers-form";
    }

    /**
     * Displays the thirty-day chart for therapy numbers.
     *
     * @param model the Spring MVC model
     * @param id the client ID
     * @return the view name to render
     */
    @GetMapping("/dashboard/chart-30")
    public String showThirtyDaysChart(Model model, @RequestParam("id") int id){
        String thirtyDaysAgoString = LocalDate.now().minusMonths(1)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String nowDateString =LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<String> dateLabels = numberService.findDatetimeLabels(thirtyDaysAgoString,nowDateString,id);
        List<Integer> anxietyScoreBuckets = numberService.findAnxietyNumberBydatetime(thirtyDaysAgoString,nowDateString,id);
        List<Integer> depressionScoreBuckets = numberService.findDepressionBuckets(thirtyDaysAgoString,nowDateString,id);
        List<Integer> energyLevelBuckets = numberService.findEnergyLevelBuckets(thirtyDaysAgoString,nowDateString,id);
        List<Integer> cravingLevelBuckets = numberService.findCravingBuckets(thirtyDaysAgoString,nowDateString,id);
        List<Integer> selfHarmLevelBuckets = numberService.findSelfHarmBuckets(thirtyDaysAgoString,nowDateString,id);
        List<Integer> impulseLevelBuckets = numberService.findImpulseBuckets(thirtyDaysAgoString,nowDateString,id);
        model.addAttribute("labels", dateLabels);
        model.addAttribute("anxietyData", anxietyScoreBuckets);
        model.addAttribute("depressionData", depressionScoreBuckets);
        model.addAttribute("energyLevelData", energyLevelBuckets);
        model.addAttribute("cravingLevelData", cravingLevelBuckets);
        model.addAttribute("selfHarmLevelData", selfHarmLevelBuckets);
        model.addAttribute("impulseLevelData", impulseLevelBuckets);
        model.addAttribute("id",id);
        return "therapy/numbers-metric-thirty";
    }

    /**
     * Retrieves therapy overview data for a given client ID.
     *
     * @param model the Spring MVC model
     * @param id the client ID
     * @return the view name to render
     */
    @GetMapping("/dashboard/overview")
    public String showOverview(Model model, @RequestParam("id") int id){
        String thirtydayago = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Integer> anxietyPieChartData = numberService.fetchAnxietyPie(thirtydayago,currentDate,id);
        List<Integer> depressionPieChartData = numberService.fetchDepressionPie(thirtydayago,currentDate,id);
        List<Integer> energyPieChartData = numberService.fetchEnergyPie(thirtydayago,currentDate,id);
        List<Integer> cravingPieChartData = numberService.fetchCravingPie(thirtydayago,currentDate,id);
        List<Integer> selfHarmPieChartData = numberService.fetchSelfHarmPie(thirtydayago,currentDate,id);
        List<Integer> impulsePieChartData = numberService.fetchImpulsePie(thirtydayago,currentDate,id);
        model.addAttribute("labels", Arrays.asList("0","1","2","3","4","5","6","7"));
        model.addAttribute("anxietyData", anxietyPieChartData);
        model.addAttribute("depressionData", depressionPieChartData);
        model.addAttribute("energyLevelData", energyPieChartData);
        model.addAttribute("cravingLevelData", cravingPieChartData);
        model.addAttribute("selfHarmLevelData", selfHarmPieChartData);
        model.addAttribute("impulseLevelData", impulsePieChartData);
        model.addAttribute("id", id);
        return "therapy/numbers-metric-overview";
    }

}
