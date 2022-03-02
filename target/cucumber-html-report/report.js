$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("demoQA/DemoQa.feature");
formatter.feature({
  "line": 2,
  "name": "Tests of DemoQa",
  "description": "ETQ utilisateurs je vais faire une liste des tests sur le site demoQa",
  "id": "tests-of-demoqa",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@demo"
    }
  ]
});
formatter.before({
  "duration": 3547587800,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "put mouse on web element",
  "description": "",
  "id": "tests-of-demoqa;put-mouse-on-web-element",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@Mousehover"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "je me connecte sur application demo qa \"mousehover\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "je met le souris sur Main item2",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "je fais une capture écran",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "je vérifie les items sont affichés et les captures écrans sont conformes",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "mousehover",
      "offset": 40
    }
  ],
  "location": "mouseHoverStepDefinition.jeMeConnecteSurApplicationDemoQa(String)"
});
formatter.result({
  "duration": 2008482900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 30
    }
  ],
  "location": "mouseHoverStepDefinition.jeMetLeSourisSurMainItem(int)"
});
formatter.result({
  "duration": 57273500,
  "status": "passed"
});
formatter.match({
  "location": "mouseHoverStepDefinition.jeFaisUneCaptureÉcran()"
});
formatter.result({
  "duration": 3137258000,
  "status": "passed"
});
formatter.match({
  "location": "mouseHoverStepDefinition.jeVérifieLesItemsSontAffichésEtLesCapturesÉcransSontConformes()"
});
formatter.result({
  "duration": 49600,
  "status": "passed"
});
formatter.after({
  "duration": 1043891700,
  "status": "passed"
});
});