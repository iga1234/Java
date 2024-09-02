Task Description

In this game, two generals each command an army of soldiers and have a sack of gold coins.
Soldiers

Soldiers have:

    Military rank: Private (value: 1), Corporal (value: 2), Captain (value: 3), and Major (value: 4)
    Experience
    Soldier strength is calculated as the product of their rank and experience
    A soldier dies when their experience reaches 0
    When experience reaches five times the value of their rank, the soldier is promoted to the next rank, and their experience is reset to 1

Generals

Generals have an initial (limited) number of gold coins. The goal of each general is to have the strongest and most skilled army.

A general can:

    Conduct maneuvers with their army (or part of it), which increases the experience of participating soldiers by 1. Maneuvers cost: for each soldier participating, the general pays an amount equal to the rank value.
    Attack the other general: The general with the higher total strength of their army wins. The loser transfers 10% of their gold to the winner. Each soldier in the losing army loses 1 experience point, while each soldier in the winning army gains 1 experience point. In the case of a draw, each general must execute one randomly selected soldier from their army.
    Buy soldiers: The cost of a soldier is 10 * their rank value. Purchased soldiers have an initial experience of 1.

The Secretary of the President observes the generals and writes reports about both armies. The reports describe all actions taken by the generals and changes in individual soldiers.

Each general, along with their resources, should be able to save and load their state from/to disk.
Evaluation Criteria

    Class Creation: 10%
    Composition: 10%
    Inheritance: 20%
    Implementation of Design Patterns: 30%
    Implementation of Described Algorithms: 20%
    Polymorphism: 10%

Notes

The project should also include appropriate unit tests for the implemented functionality.