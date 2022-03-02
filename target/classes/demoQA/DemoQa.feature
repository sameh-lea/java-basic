@demo
Feature: Tests of DemoQa
  ETQ utilisateurs je vais faire une liste des tests sur le site demoQa

  @Mousehover
  Scenario: put mouse on web element
    Given je me connecte sur application demo qa "mousehover"
    When je met le souris sur Main item2
    And je fais une capture écran
    Then je vérifie les items sont affichés et les captures écrans sont conformes 
