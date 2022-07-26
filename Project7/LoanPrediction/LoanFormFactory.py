from Client import Client
from LoanForm import LoanForm


class LoanFormFactory:

    @staticmethod
    async def create_loan_form(gender, married, self_employed, education, credit_history, property_area,
                               loan_amount, loan_term_months, client: Client) -> LoanForm:

        loan_form_1 = LoanForm(gender, married, self_employed, education, credit_history, property_area,
                               loan_amount, loan_term_months)

        from models.LoanFormModel import LoanFormModel
        await LoanFormModel.create(loan_id=loan_form_1.loan_id, gender=loan_form_1.gender, married=loan_form_1.married,
                                   self_employed=loan_form_1.self_employed, education=loan_form_1.education,
                                   credit_history=loan_form_1.credit_history, property_area=loan_form_1.property_area,
                                   loan_amount=loan_form_1.loan_amount, loan_term_months=loan_form_1.loan_term_months,
                                   loan_amount_remaining=loan_form_1.loan_amount)

        client.loan_id = loan_form_1.loan_id
        client.loanPredictionForm = loan_form_1

        from models.ClientModel import ClientModel
        client_model = await ClientModel.query.where(ClientModel.bank_id == client.bank_id).gino.first()
        if client_model:
            await client_model.update(loan_id=loan_form_1.loan_id).apply()

        return loan_form_1
