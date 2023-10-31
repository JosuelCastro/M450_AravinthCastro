describe('Login', () => {
  it('tries to log in as user', () => {
    cy.visit('http://localhost:3000')

    cy.get('.nav-link')
        .eq(3)
        .click()

    cy.get('#email')
        .type('micky.dai@gmail.com')

    cy.get('#password')
        .type('1234')

    cy.get('.MuiButtonBase-root')
        .click()
  })
})

describe('Home', () => {
  it('checks if the Homepage is correct', () => {
    cy.visit('http://localhost:3000')
    cy.get('.nav-link').eq(0).click()
    cy.get('.MuiBox-root')
        .should('exist')
        .contains('Get Started')

  })

  it('checks if the Get Started Button works', () => {
    cy.visit('http://localhost:3000')

    cy.get('.nav-link').eq(0).click()

    cy.get('.MuiButtonBase-root')
        .click()


    cy.get('.MuiButtonBase-root')
        .click()
        .get('.MuiPaper-root')
        .contains('Sign In')
  })
})


describe('User Registration', () => {
  it('should register a new user', () => {
    cy.visit('http://localhost:3000/register');

    cy.get('#username').type('newUser');
    cy.get('#email').type('newuser@example.com');
    cy.get('#password').type('password123');
    cy.contains('button', 'Register').click();

    // Add assertions to check if registration was successful
  });
});

describe('User Profile', () => {
  it('should update user profile information', () => {
    cy.visit('http://localhost:3000/login');

    // Assuming user is logged in
    cy.get('#email').type('user@example.com');
    cy.get('#password').type('password123');
    cy.get('.login-button').click();

    cy.visit('http://localhost:3000/profile');
    cy.get('#firstName').clear().type('UpdatedFirstName');
    cy.get('#lastName').clear().type('UpdatedLastName');
    cy.get('.save-profile-button').click();

    // Add assertions to check if profile update was successful
  });
});

describe('Navigation', () => {
  it('should navigate to different pages', () => {
    cy.visit('http://localhost:3000');

    cy.get('.nav-link-home').click();
    cy.url().should('include', '/home');

    cy.get('.nav-link-profile').click();
    cy.url().should('include', '/profile');

    // Add more navigation tests as needed
  });
});