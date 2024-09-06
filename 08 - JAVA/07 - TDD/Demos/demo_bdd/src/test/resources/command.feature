    Feature: Command Ordering

        as a customer i want to make command for someone

            Scenario: Creation of an empty Command
                Given Customer who wants to command for Someone : "Toto"
                When a Command is made for Someone
                Then there is no product in Command
                And the command come from Customer