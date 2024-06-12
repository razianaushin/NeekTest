
    // Step 1: Wait for the page to fully load
    const generateRandomName = () => {
        const firstNames = ['Warnakulasuriya Patabendige', 'Benjamin', 'Catherine', 'David', 'Elizabeth', 'Frederick luke', 'Gabriella', 'Henry', 'Isabella', 'Jonathan'];
        const lastNames = ['Anderson', 'Brown', 'Carter Chaminda', 'Davis', 'Evans', 'Garcia', 'Harris', 'Johnson sachin', 'Martinez Vaas', 'Williams'];
        const firstName = firstNames[Math.floor(Math.random() * firstNames.length)];
        const lastName = lastNames[Math.floor(Math.random() * lastNames.length)];
        return `${firstName} ${lastName}`;
    };

    // Function to generate a random email (RFC 5321 compliant)
    const generateRandomEmail = (name) => {
        const domains = ['example.com', 'test.com', 'sample.org', 'demo.net'];
        const domain = domains[Math.floor(Math.random() * domains.length)];
        const email = `${name.replace(/ /g, '.').toLowerCase()}@${domain}`;
        return email;
    };

    // Function to generate a valid Australian phone number
    const generateRandomPhoneNumber = () => {
        const prefix = '04';
        const number = Math.floor(10000000 + Math.random() * 90000000);
        return `${prefix}${number}`;
    };

    //Get Random number
    function getRandomInt(max) {
        return Math.floor(1,Math.random() * max);
    }

    // Function to generate the message field content
    const generateMessage = (name, iteration) => {
        return `${name}, functionality and iteration data number ${iteration}`;
    };


      // Function to fill out and submit the form with random data
      const fillAndSubmitForm = (iteration) => {
        const name = generateRandomName();
        const email = generateRandomEmail(name);
        const phone = generateRandomPhoneNumber();
        const message = generateMessage(name, iteration);

        const formField =document.querySelector('form[name="enquirerFrom"]');
        const nameField = document.querySelector('input[name="name"]');
        const emailField = document.querySelector('input[formcontrolname="email"]');
        const phoneField = document.querySelector('input[id="phone"]');
        const postCode = document.querySelector('input[name="postCode"]');
        const buyerType = document.querySelector('select[name="buyerType"]');
        const priceRange = document.querySelector('select[name="priceRange"]');
        const buyingDuration = document.querySelector('select[name="buyingDuration"]');
        const contactMethod = document.querySelector('select[name="contactMethod"]');
        const selectPreApproval = document.querySelector('select[name="selectPreApproval"]');
        const scheduleInspection = document.querySelector('input[name="scheduleInspection"]');
        const priceInformation = document.querySelector('input[name="priceInformation"]');
        const requestFloorPlans = document.querySelector('input[name="requestFloorPlans"]');
        const brochure = document.querySelector('input[name="brochure"]');
        const messageLink = document.querySelector('.add-message-toggle');
        const messageField = document.querySelector('textarea[name="message"]');
        const submitButton = formField.querySelector('button[type="submit"]');
    
    

        if (nameField && emailField && phoneField && postCode && buyerType && priceRange && buyingDuration && contactMethod && selectPreApproval && scheduleInspection
            && priceInformation && requestFloorPlans && brochure && messageField && submitButton) {
                nameField.click()
            nameField.value = name;
            emailField.value = email;
            phoneField.value = phone;
            postCode.value = 1234;
            buyerType.getElementsByTagName('option')[getRandomInt(5)].selected = 'selected'
            priceRange.getElementsByTagName('option')[getRandomInt(11)].selected = 'selected'
            buyingDuration.getElementsByTagName('option')[getRandomInt(4)].selected = 'selected'
            contactMethod.getElementsByTagName('option')[getRandomInt(2)].selected = 'selected'
            selectPreApproval.getElementsByTagName('option')[getRandomInt(1)].selected = 'selected'
            scheduleInspection.checked=true;
            priceInformation.checked=true;
            requestFloorPlans.checked=true;
            brochure.checked=true;
            messageLink.click()
            messageField.value = message;

            nameField.dispatchEvent(new Event('input', {bubbles: true}))
            emailField.dispatchEvent(new Event('input', {bubbles: true}))
            phoneField.dispatchEvent(new Event('input', {bubbles: true}))
            submitButton.click();
    

            //setTimeout(() => {document.querySelector(".sms-close").click();}, 8000);
            // Submit the form
            
        } else {
            // Retry if form elements are not yet available
            setTimeout(() => fillAndSubmitForm(iteration), 5000);
        }
    };
    // Step 2: Find and click the "Enquire" button
    // Function to perform the actions for each data set
    const performActions = (iteration) => {
        // Click the Enquire button
        const enquireButton = document.querySelector('span.mat-button-wrapper');

        setTimeout(enquireButton.click(),5000);
        

        // Wait for the form to appear and fill it out
        setTimeout(() => fillAndSubmitForm(iteration), 2000);


    };

    // Loop to submit the form 20 times with different data
    for (let i = 1; i <= 20; i++) {
        setTimeout(() => performActions(i), i * 5000);  // Adjust the delay as needed
    }
