var lastName = new Array();
var firstName = new Array();
var middleName = new Array();
var shortName = new Array();
var variable;
var i;
function SelectShortName() {
    variable = '1';
    var req = new XMLHttpRequest();
    req.open("GET", "crudRequestSelect.json", true);
    JSON.stringify(variable);
    req.send(null);
    for (i = 0; i < shortName.length + 1; i++) {
        shortName[i] = lastName[i]  + " " + firstName[i] + " " +  middleName[i];
        if (lastName[i] == undefined || firstName[i] == undefined || middleName[i] == undefined) {
            shortName = 'Данные о сотрудниках отсутствуют.';
        return shortName[i];
        }
    }
}