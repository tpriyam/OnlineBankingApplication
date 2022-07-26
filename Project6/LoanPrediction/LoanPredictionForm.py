class LoanPredictionForm:

    def __init__(self, gender, loanAmount, loanAmountTerm):
        self.gender = gender
        # self.married = married
        # self.dependents = dependents
        self.loanAmount = loanAmount
        self.loanAmountTerm = loanAmountTerm
        # education, self-employed, applicantIncome, coApplicantIncome,
        # creditHistory, propertyArea, loanStatus

    def __str__(self):
        print(self.gender, self.loanAmount, self.loanAmountTerm)
