# Programming Paradigms

Electric Vehicles have BMS - Battery Management Systems

[Here is an article that helps to understand the need for BMS](https://circuitdigest.com/article/battery-management-system-bms-for-electric-vehicles)

[Wikipedia gives an idea of the types and topologies](https://en.wikipedia.org/wiki/Battery_management_system)

[This site gives the optimum Charging-temperature limits](https://batteryuniversity.com/learn/article/charging_at_high_and_low_temperatures)

[This abstract suggests a range for the optimum State of Charge](https://www.sciencedirect.com/science/article/pii/S2352484719310911)

[Here is a reference for the maximum charge rate](https://www.electronics-notes.com/articles/electronic_components/battery-technology/li-ion-lithium-ion-charging.php#:~:text=Constant%20current%20charge:%20In%20the%20first%20stage%20of,rate%20of%20a%20maximum%20of%200.8C%20is%20recommended.)

## Possible purpose

- Protect batteries while charging:
at home, in public place, within vehicle / regenerative braking
- Estimate life, inventory and supply chains

## The Starting Point

We will explore the charging phase of Li-ion batteries to start with.

## Issues

- The code here has high complexity in a single function.
- The tests are not complete - they do not cover all the needs of a consumer

## Tasks

1. Reduce the cyclometric complexity.
1. Separate pure functions from I/O
1. Avoid duplication - functions that do nearly the same thing
1. Complete the tests - cover all conditions.
1. To take effective action, we need to know
the abnormal measure and the breach -
whether high or low. Add this capability.

## The Exploration

How well does our code hold-out in the rapidly evolving EV space?
Can we add new functionality without disturbing the old?

## The Landscape

- Limits may change based on new research
- Technology changes due to obsolescence
- Sensors may be from different vendors with different accuracy
- Predicting the future requires Astrology!

## Keep it Simple

Shorten the Semantic distance

- Procedural to express sequence
- Functional to express relation between input and output
- Object oriented to encapsulate state with actions
- Aspect oriented to capture repeating aspects

## Assignment Approach

As mentioned in the problem statement, 

- the solution should be very much customizable since limits/technology is unpredictable. 
- In addition, cyclometric complexity reduction and separation of pure functions were also requested.
- Current feature of notifying whether a parameter is out of range is to be enhanced with whether it is high or low.
- Finally, test coverage should be improved.

Keeping these points in mind and trying to implement at least a significant part using Functional Paradigm, I approached to the current design.

| Class Name        | Purpose                                                      | Remarks                                                      |
| ----------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| **BMS**           | Wrapper class that allows instantiation with changed limits. | Should help in keeping up with the changing technologies.    |
| **BMSChecker**    | Validator class holding various methods to validate temp, soc and cr. | Tried to implement using Functional Paradigm.                |
| **BMSTester**     | Tester class to test the validation results for various situations. | Should increase test coverage.                               |
| **MonitorStates** | Enum to hold various states of the monitoring process.       | Avoids using hardcoded values directly.                      |
| **BMSDriver**     | Driver class to execute the testcases.                       | Unnecessary class, had to be created as maven integration was failing. |

