document.getElementById("summary").addEventListener("click", summaryForm);
function summaryForm(){
    // categories
    const checkboxes= Array.from(document.querySelectorAll("#checkbox"));
    const selectedCheckboxes = checkboxes.filter(function(element){
        return element.firstElementChild.checked;
    })
    console.log(selectedCheckboxes)
    let categoriesString = "";
    selectedCheckboxes.forEach(function(element, index, array){
        categoriesString += element.children[3].innerText;
        if(index< array.length - 1) categoriesString += ", ";
    })
    document.getElementById("summaryCategories").innerText = categoriesString;

    //institutions
    const radios= Array.from(document.querySelectorAll("#institution"));
    const selectedRadios = radios.filter(function(element){
        return element.checked;
    })
    const selectedRadio = selectedRadios[0];
    document.getElementById("summaryInstitution").innerText = selectedRadio.parentElement.children[2].firstElementChild.innerHTML;

    //bags
    $("#summaryBags").text($("#bags").val());

    //ulica
    $("#summaryStreet").text($("#street").val());

    //miasto
    $("#summaryCity").text($("#city").val());

    //kod pocztowy
    $("#summaryPostCode").text($("#postCode").val());

    //telefon
    $("#summaryPhone").text($("#phone").val());

    //data
    $("#summaryDate").text($("#date").val());

    //godzina
    $("#summaryTime").text($("#time").val());

    //uwagi
    $("#summaryComment").text($("#more_info").val());
}