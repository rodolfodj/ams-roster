package br.com.mesttra.roster.rest;

import br.com.mesttra.roster.entity.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "financialClient", url = "http://localhost:8082")
public interface FinancialClient {

    @RequestMapping(method = RequestMethod.POST, value = "/hiring")
    void hirePlayer(@RequestBody Player player);
}
