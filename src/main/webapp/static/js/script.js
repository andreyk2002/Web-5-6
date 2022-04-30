let errors = [];
let inputsValues = new Map();
const projectForm = "createProjectForm";

function validateInput(event) {
    let input = event.target
    let id = input.id
    let name = input.name
    let inputValue = input.value
    inputsValues.set(id, input)
    if (name === "description") {
        if (inputValue.length < 5) {
            let errorHtml = "<br/><p id=\"desc-error\" class=\"text-danger\">description should contain more than 5 symbols</p>";
            input.insertAdjacentHTML('beforeBegin', errorHtml)
            errors.push({inputId: id, errorHtml: errorHtml})
        } else {
            let errorInput = document.getElementById("desc-error");
            errorInput.parentNode.removeChild(errorInput)
            errors = errors.filter(error => error.id = id)
        }
    }
    if (name === "projectName") {
        if (inputValue.length < 3) {
            let errorHtml = "<br/><p id=\"name-error\" class=\"text-danger\">project name should contain more than 2 symbols</p>";
            input.insertAdjacentHTML('beforeBegin', errorHtml)
            errors.push({inputId: id, errorHtml: errorHtml})
        } else {
            let errorInput = document.getElementById("name-error");
            errorInput.parentNode.removeChild(errorInput)
            errors = errors.filter(error => error.id = id)
        }
    }
    if (name === "minQualification") {
        if (!["low", "high", "middle", "god tier"].includes(inputValue)) {
            let errorHtml = "<br/><p id=\"qualification-error\" class=\"text-danger\">Qualification can be one of 4 values - low, high, middle, god tier</p>";
            input.insertAdjacentHTML('beforeBegin', errorHtml)
            errors.push({inputId: id, errorHtml: errorHtml})
        } else {
            let errorInput = document.getElementById("qualification-error");
            errorInput.parentNode.removeChild(errorInput)
            errors = errors.filter(error => error.id = id)
        }
    }
}

const dom = (function () {
        let formId = "";

        let createProjectForm = {
            projectDescription: {
                label: "Описание проекта",
                type: "string",
                class: "form-control",
                placeholder: "Введите описание проекта",
                name: "description",
                id: "description-input",
            },
            projectName: {
                label: "Имя проекта",
                type: "string",
                class: "form-control",
                placeholder: "Введите имя проекта",
                name: "projectName",
                id: "projectName-input",
            },
            workersCount: {
                label: "Число работников",
                type: "number",
                class: "form-control",
                placeholder: "Введите требуемое число работников",
                name: "workersCount",
                minValue: "1",
                step: "1",
                id: "workersCount-input",
            },
            minQualification: {
                label: "Минимальная квалификация",
                type: "string",
                class: "form-control",
                placeholder: "Введите мин квалификацию",
                name: "minQualification",
                id: "minQualification-input",
            },
            submitButton: {
                type: "submit",
                class: "btn btn-primary",
                value: "Подтвердить",
            }
        };


        function buildForm(form, type) {
            let array;
            if (type === projectForm) {
                array = createProjectForm;
            }

            for (const prop in array) {
                if (array[prop].type === "submit") {
                    const submit = document.createElement("input");
                    submit.setAttribute("type", array[prop].type);
                    submit.setAttribute("class", array[prop].class);
                    submit.value = array[prop].value;
                    form.appendChild(submit);
                } else {
                    const formDiv = document.createElement("div");
                    formDiv.setAttribute("class", "form-group");
                    const label = document.createElement("label");
                    label.innerHTML = array[prop].label;
                    formDiv.appendChild(label);
                    const input = document.createElement("input");
                    input.setAttribute("type", array[prop].type);
                    input.setAttribute("class", array[prop].class);
                    input.setAttribute("placeholder", array[prop].placeholder);
                    input.setAttribute("name", array[prop].name);
                    input.setAttribute("min", array[prop].minValue);
                    input.setAttribute("step", array[prop].step);
                    input.setAttribute("id", array[prop].id);
                    input.required = true;
                    formDiv.appendChild(input);
                    form.appendChild(formDiv);
                    input.addEventListener("change", validateInput)
                }
            }
        }

        function appendErrors() {
            errors.forEach((error) => {
                document.getElementById(error.id).insertAdjacentHTML('beforeBegin', error.errorHtml)
            });

            errors = []
        }

        function initPage() {
            const testForm = document.getElementById("filter-form");
            if (testForm != null) {
                buildForm(testForm, "testForm");
                formId = "filter-form";
                return;
            }

            const createProjectForm = document.getElementById(
                "create-project-form"
            );


            if (createProjectForm != null) {
                buildForm(createProjectForm, projectForm);
                appendErrors()
                formId = "create-project-form";
            }
        }

        return {initPage};
    }

)
();

dom.initPage();
