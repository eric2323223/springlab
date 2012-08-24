package net.stsmedia.financemanager.service.impl;

import net.stsmedia.financemanager.dao.GenericDAOWithJPA;
import net.stsmedia.financemanager.domain.Investment;
import net.stsmedia.financemanager.service.InvestmentService;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * This is a service layer implementation for {@link InvestmentService}. Note
 * that most of these methods from the interface are implemented by
 * {@link GenericDAOWithJPA}.
 * 
 * This class also provides the functionality of the repository. More
 * information about this in my blog article entitled 'Spring Finance > Part 3:
 * DDD, JPA & Transactions' published at StSMedia.net
 * 
 * @author Stefan Schmidt
 * @since 0.2
 * 
 */
@Service("investmentService")
@Repository
public class InvestmentServiceImpl extends GenericDAOWithJPA<Investment, Long> implements InvestmentService {
}
