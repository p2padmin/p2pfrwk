package com.finance.p2p.core.loan;

import org.springframework.stereotype.Repository;

import com.finance.p2p.common.GenericDaoJpa;

@Repository
public class LoanDaoJpa extends GenericDaoJpa<Loan> implements LoanDao {

	public LoanDaoJpa() {
		super(Loan.class);

	}

}
