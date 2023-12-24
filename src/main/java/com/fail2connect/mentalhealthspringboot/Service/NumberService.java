package com.fail2connect.mentalhealthspringboot.Service;

import com.fail2connect.mentalhealthspringboot.models.TherapyNumber;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface NumberService {

    List<TherapyNumber> findAll();

    TherapyNumber findByID(int id);
    TherapyNumber findTherapyNumberByNumberId (int numberId);
    TherapyNumber save(TherapyNumber therapyNumber);
    void deleteByID(int id);
    List<TherapyNumber> findAllByClientId(int id);

    List<Integer> findAnxietyNumberBydatetime(String startDate,String endDate, int id);
    List<Integer> findDepressionBuckets(String startDate,String endDate, int id);
    List<Integer> findEnergyLevelBuckets(String startDate,String endDate, int id);
    List<Integer> findCravingBuckets(String startDate,String endDate, int id);
    List<Integer> findSelfHarmBuckets (String startDate,String endDate, int id);
    List<String> findDatetimeLabels (String startDate, String endDate, int id );
    List<Integer> findImpulseBuckets (String startDate, String endDate, int id);
    List<Integer> fetchAnxietyPie (String startDate, String endDate, int id);

    List<Integer> fetchDepressionPie(String startDate, String endDate, int id);

    List<Integer> fetchEnergyPie(String startDate, String endDate, int id);
    List<Integer> fetchCravingPie (String startDate, String endDate, int id);
    List<Integer> fetchSelfHarmPie (String startDate, String endDate, int id);
    List<Integer> fetchImpulsePie(String startDate, String endDate, int id);
}
