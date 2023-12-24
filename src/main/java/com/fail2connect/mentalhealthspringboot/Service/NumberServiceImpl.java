package com.fail2connect.mentalhealthspringboot.Service;

import com.fail2connect.mentalhealthspringboot.dao.NumberRepo;
import com.fail2connect.mentalhealthspringboot.models.TherapyNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NumberServiceImpl implements NumberService{

    private final NumberRepo numberRepo;

    @Autowired
    public NumberServiceImpl (NumberRepo numberRepo){
        this.numberRepo = numberRepo;
    }

    @Override
    public List<TherapyNumber> findAll() {
        return numberRepo.findAll();
    }

    @Override
    public TherapyNumber findByID(int id) {
        Optional<TherapyNumber> result = numberRepo.findById(id);
        TherapyNumber therapyNumber = null;
        if(result.isPresent()){
            therapyNumber = result.get();
        }
        else{
            throw new RuntimeException("Didn't find the number id -" + id);
        }
        return therapyNumber;
    }

    @Override
    public TherapyNumber findTherapyNumberByNumberId(int numberId) {
        return numberRepo.findTherapyNumberByNumberId(numberId);
    }

    @Override
    public TherapyNumber save(TherapyNumber therapyNumber) {
        return numberRepo.save(therapyNumber);
    }

    @Override
    public void deleteByID(int id) {
        numberRepo.deleteById(id);
    }

    @Override
    public List<TherapyNumber> findAllByClientId(int id) {
        return numberRepo.findAllByClientId(id,Sort.by(Sort.Direction.ASC, "datetime"));
    }

    @Override
    public List<Integer> findAnxietyNumberBydatetime(String startDate,String endDate ,int id) {

        return numberRepo.findAnxietyNumberBydatetime(startDate,endDate, id, Sort.by(Sort.Direction.ASC,"datetime"));
    }

    @Override
    public List<Integer> findDepressionBuckets(String startDate,String endDate, int id) {
        return numberRepo.findDepressionBuckets(startDate,endDate,id, Sort.by(Sort.Direction.ASC,"datetime"));
    }

    @Override
    public List<Integer> findEnergyLevelBuckets(String startDate,String endDate, int id) {
        return numberRepo.findEnergyLevelBuckets(startDate,endDate,id, Sort.by(Sort.Direction.ASC,"datetime"));
    }

    @Override
    public List<Integer> findCravingBuckets(String startDate, String endDate, int id) {
        return numberRepo.findCravingBuckets(startDate,endDate,id, Sort.by(Sort.Direction.ASC,"datetime"));
    }

    @Override
    public List<Integer> findSelfHarmBuckets(String startDate, String endDate, int id) {
        return numberRepo.findSelfHarmBuckets(startDate, endDate,id, Sort.by(Sort.Direction.ASC, "datetime"));
    }

    @Override
    public List<String> findDatetimeLabels(String startDate, String endDate, int id) {
        return numberRepo.findDatetimeLabels(startDate,endDate,id, Sort.by(Sort.Direction.ASC,"datetime"));
    }

    @Override
    public List<Integer> findImpulseBuckets(String startDate, String endDate, int id) {
        return numberRepo.findImpulseBuckets(startDate,endDate,id,Sort.by(Sort.Direction.ASC, "datetime"));
    }

    @Override
    public List<Integer> fetchAnxietyPie(String startDate, String endDate, int id) {
        return numberRepo.fetchAnxietyPie(startDate,endDate,id);
    }

    @Override
    public List<Integer> fetchDepressionPie(String startDate, String endDate, int id) {
        return numberRepo.fetchDepressionPie(startDate,endDate,id);
    }

    @Override
    public List<Integer> fetchEnergyPie(String startDate, String endDate, int id) {
        return numberRepo.fetchEnergyPie(startDate,endDate,id);
    }

    @Override
    public List<Integer> fetchCravingPie(String startDate, String endDate, int id) {
        return numberRepo.fetchCravingPie(startDate,endDate,id);
    }

    @Override
    public List<Integer> fetchSelfHarmPie(String startDate, String endDate, int id) {
        return numberRepo.fetchSelfHarmPie(startDate,endDate,id);
    }

    @Override
    public List<Integer> fetchImpulsePie(String startDate, String endDate, int id) {
        return numberRepo.fetchImpulsePie(startDate,endDate,id);
    }

}
