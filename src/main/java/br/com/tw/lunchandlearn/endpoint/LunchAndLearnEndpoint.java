package br.com.tw.lunchandlearn.endpoint;

import br.com.tw.lunchandlearn.domain.LunchAndLearn;
import br.com.tw.lunchandlearn.infrastructure.SpreadSheetClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LunchAndLearnEndpoint {

    @Autowired
    private SpreadSheetClient spreadSheetClient;

    @RequestMapping("/lunchandlearns")
    public List<LunchAndLearn> findAlllunchAndLearns() throws Exception {
        return spreadSheetClient.getAllLunchAndLearns();
    }

}
