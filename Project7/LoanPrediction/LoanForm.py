class LoanForm:

    __loan_id_counter = 100001

    def __init__(self, gender, married, self_employed, education, credit_history, property_area,
                 loan_amount, loan_term_months):

        self.loan_id = LoanForm.__loan_id_counter
        LoanForm.__loan_id_counter += 1
        self.gender = gender
        self.married = married
        self.self_employed = self_employed
        self.education = education
        self.credit_history = credit_history
        self.property_area = property_area
        self.loan_amount = loan_amount
        self.loan_term_months = loan_term_months
        self.loan_amount_remaining = loan_amount
        # education, self_employed, applicantIncome, coApplicantIncome,
        # creditHistory, propertyArea, loanStatus

    def __str__(self):
        return str(self.loan_id) + self.gender + str(self.loan_amount) + str(self.loan_term_months)
