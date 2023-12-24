package com.fail2connect.mentalhealthspringboot.dao;

import com.fail2connect.mentalhealthspringboot.models.Client;
import com.fail2connect.mentalhealthspringboot.models.TherapyNumber;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface NumberRepo extends JpaRepository<TherapyNumber, Integer> {
    /**
     * Retrieves a list of TherapyNumbers associated with a given client ID.
     *
     * @param id the ID of the client
     * @return a list of TherapyNumbers associated with the client ID
     */
    @Query("select t from TherapyNumber t where t.client.clientId = ?1")
    List<TherapyNumber> findAllByClientId(@Param("id") int id, Sort sort);

    @Query("Select n from TherapyNumber n where n.numberId = :numberId")
    TherapyNumber findTherapyNumberByNumberId(@Param("numberId") int numberId);

    @Query("Select n.datetime from TherapyNumber n where n.client.clientId = :id and n.datetime between :startDate and :endDate")
    List<String> findDatetimeLabels (@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("id") int id, Sort sort);

    /**
     * Finds the sum of anxiety scores in various ranges for a given start date and client ID.
     *
     * @param startDate the starting date from which to filter the therapy numbers
     * @param id the client ID to filter the therapy numbers
     * @return a list of integers representing the sum of anxiety scores in different ranges, without any example code
     */

    @Query("select n.anxietyScore from TherapyNumber n where n.datetime between :startDate and :endDate and n.client.clientId= :id")
     List<Integer> findAnxietyNumberBydatetime (@Param ("startDate") String startDate,@Param("endDate") String endDate,@Param("id") int id, Sort sort);


    @Query("select n.depressionScore FROM TherapyNumber n WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id ")
    List<Integer> findDepressionBuckets(@Param ("startDate") String startDate,@Param("endDate") String endDate, @Param("id") int id, Sort sort);

    @Query("Select n.energyLevelScore FROM TherapyNumber n WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id ")
    List<Integer> findEnergyLevelBuckets(@Param ("startDate") String startDate, @Param("endDate") String endDate, @Param("id") int id, Sort sort);

    @Query("Select n.cravingScore FROM TherapyNumber n WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id ")
    List<Integer> findCravingBuckets(@Param ("startDate") String startDate, @Param("endDate") String endDate, @Param("id") int id, Sort sort);

    @Query("Select n.selfHarmScore FROM TherapyNumber n WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id ")
    List<Integer> findSelfHarmBuckets(@Param ("startDate") String startDate,@Param("endDate") String endDate, @Param("id") int id, Sort sort);

    @Query("Select n.impulseScore from TherapyNumber n where n.datetime between :startDate and :endDate and n.client.clientId= :id")
    List<Integer> findImpulseBuckets(@Param("startDate")String startDate, @Param("endDate") String endDate, @Param("id") int id, Sort sort);


    @Query("SELECT sum(case when n.anxietyScore = 0  then 1 else 0 end) as sum, '0' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id " +
            "UNION ALL " +
            "SELECT sum(case when n.anxietyScore = 1 then 1 else 0 end) as sum, '1 ' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.anxietyScore = 2 then 1 else 0 end) as sum, '2' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id " +
            "UNION ALL " +
            "SELECT sum(case when n.anxietyScore = 3 then 1 else 0 end) as sum, '3' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.anxietyScore = 4 then 1 else 0 end) as sum, '4' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.anxietyScore = 5 then 1 else 0 end) as sum, '5' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate  and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.anxietyScore = 6 then 1 else 0 end) as sum, '6' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate  and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.anxietyScore = 7 then 1 else 0 end) as sum, '7' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id ")
    List<Integer> fetchAnxietyPie (@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("id") int id);

    @Query("SELECT sum(case when n.depressionScore = 0  then 1 else 0 end) as sum, '0' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id " +
            "UNION ALL " +
            "SELECT sum(case when n.depressionScore = 1 then 1 else 0 end) as sum, '1 ' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.depressionScore = 2 then 1 else 0 end) as sum, '2' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id " +
            "UNION ALL " +
            "SELECT sum(case when n.depressionScore = 3 then 1 else 0 end) as sum, '3' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.depressionScore = 4 then 1 else 0 end) as sum, '4' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.depressionScore = 5 then 1 else 0 end) as sum, '5' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate  and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.depressionScore = 6 then 1 else 0 end) as sum, '6' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate  and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.depressionScore = 7 then 1 else 0 end) as sum, '7' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id ")

    List<Integer> fetchDepressionPie(@Param("startDate") String startDate, @Param("endDate") String endDate,@Param("id") int id);

    @Query("SELECT sum(case when n.energyLevelScore = 0  then 1 else 0 end) as sum, '0' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id " +
            "UNION ALL " +
            "SELECT sum(case when n.energyLevelScore = 1 then 1 else 0 end) as sum, '1 ' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.energyLevelScore = 2 then 1 else 0 end) as sum, '2' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id " +
            "UNION ALL " +
            "SELECT sum(case when n.energyLevelScore = 3 then 1 else 0 end) as sum, '3' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.energyLevelScore = 4 then 1 else 0 end) as sum, '4' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.energyLevelScore = 5 then 1 else 0 end) as sum, '5' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate  and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.energyLevelScore = 6 then 1 else 0 end) as sum, '6' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate  and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.energyLevelScore = 7 then 1 else 0 end) as sum, '7' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id ")

    List<Integer> fetchEnergyPie(@Param("startDate") String startDate, @Param("endDate") String endDate,@Param("id") int id);


    @Query("SELECT sum(case when n.cravingScore = 0  then 1 else 0 end) as sum, '0' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id " +
            "UNION ALL " +
            "SELECT sum(case when n.cravingScore = 1 then 1 else 0 end) as sum, '1 ' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.cravingScore = 2 then 1 else 0 end) as sum, '2' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id " +
            "UNION ALL " +
            "SELECT sum(case when n.cravingScore = 3 then 1 else 0 end) as sum, '3' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.cravingScore = 4 then 1 else 0 end) as sum, '4' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.cravingScore = 5 then 1 else 0 end) as sum, '5' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate  and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.cravingScore = 6 then 1 else 0 end) as sum, '6' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate  and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.cravingScore = 7 then 1 else 0 end) as sum, '7' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id ")

    List<Integer> fetchCravingPie(@Param("startDate") String startDate, @Param("endDate") String endDate,@Param("id") int id);

    @Query("SELECT sum(case when n.selfHarmScore = 0  then 1 else 0 end) as sum, '0' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id " +
            "UNION ALL " +
            "SELECT sum(case when n.selfHarmScore = 1 then 1 else 0 end) as sum, '1 ' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.selfHarmScore = 2 then 1 else 0 end) as sum, '2' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id " +
            "UNION ALL " +
            "SELECT sum(case when n.selfHarmScore = 3 then 1 else 0 end) as sum, '3' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.selfHarmScore = 4 then 1 else 0 end) as sum, '4' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.selfHarmScore = 5 then 1 else 0 end) as sum, '5' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate  and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.selfHarmScore = 6 then 1 else 0 end) as sum, '6' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate  and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.selfHarmScore = 7 then 1 else 0 end) as sum, '7' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id ")

    List<Integer> fetchSelfHarmPie(@Param("startDate") String startDate, @Param("endDate") String endDate,@Param("id") int id);


    @Query("SELECT sum(case when n.impulseScore = 0  then 1 else 0 end) as sum, '0' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id " +
            "UNION ALL " +
            "SELECT sum(case when n.impulseScore = 1 then 1 else 0 end) as sum, '1 ' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.impulseScore = 2 then 1 else 0 end) as sum, '2' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id " +
            "UNION ALL " +
            "SELECT sum(case when n.impulseScore = 3 then 1 else 0 end) as sum, '3' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.impulseScore = 4 then 1 else 0 end) as sum, '4' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.impulseScore = 5 then 1 else 0 end) as sum, '5' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate  and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.impulseScore = 6 then 1 else 0 end) as sum, '6' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate  and n.client.clientId = :id "+
            "UNION ALL " +
            "SELECT sum(case when n.impulseScore = 7 then 1 else 0 end) as sum, '7' as range " +
            "FROM TherapyNumber n " +
            "WHERE n.datetime between :startDate and :endDate and n.client.clientId = :id ")

    List<Integer> fetchImpulsePie(@Param("startDate") String startDate, @Param("endDate") String endDate,@Param("id") int id);



}
