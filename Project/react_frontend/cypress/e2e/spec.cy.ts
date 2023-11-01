Cypress.Commands.add('login', () => {
  window.localStorage.setItem('token', "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlMTQ0Nzg3Ni00ZTI1LTExZWUtYmU1Ni0wMjQyYWMxMjAwMDIiLCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiVVNFUl9NT0RJRlkifSx7ImF1dGhvcml0eSI6IkFETUlOX0RFTEVURSJ9LHsiYXV0aG9yaXR5IjoiQURNSU5fUkVBRCJ9XSwiaWF0IjoxNjk4ODMyNzc0LCJleHAiOjE2OTg5MzI3NzQsImlzcyI6InVrMjIzIn0.6OB2ES73yaUOPb7ebWr2BYpOd6sI6CRQyAKJoj4RWF8")
  window.localStorage.setItem('user', "{\"id\":\"e1447876-4e25-11ee-be56-0242ac120002\",\"username\":\"Banane\",\"email\":\"banane@gmail.com\",\"password\":\"$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6\",\"roles\":[{\"id\":\"ab505c92-7280-49fd-a7de-258e618df074\",\"name\":\"ADMIN\",\"authorities\":[{\"id\":\"76d2cbf6-5845-470e-ad5f-2edb9e09a868\",\"name\":\"USER_MODIFY\"},{\"id\":\"21c942db-a275-43f8-bdd6-d048c21bf5ab\",\"name\":\"ADMIN_DELETE\"},{\"id\":\"ba804cb9-fa14-42a5-afaf-be488742fc54\",\"name\":\"ADMIN_READ\"}]}]}")
})

beforeEach(()=> {
  cy.login()
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

describe('Login', () => {
  it('tries to log in as user', () => {

    cy.visit('http://localhost:3000/user/login')

    cy.get('#email')
        .type('micky.dai@gmail.com')

    cy.get('#password')
        .type('1234')

    cy.get('.MuiButtonBase-root')
        .click()
  })
})


// cypress/integration/navigation.spec.js

describe('Navigation', () => {
  it('should navigate to different pages', () => {
    cy.visit('http://localhost:3000');

    // Navigate to Home
    cy.get('.nav-link').contains('Home').click();
    cy.url().should('include', '/');

    // Navigate to Profile
    cy.get('.nav-link').contains('Profile').click();
    cy.url().should('include', '/userprofile');

    // Navigate to Admin
    cy.get('.nav-link').contains('Admin').click();
    cy.url().should('include', '/users');

    // Add more navigation tests as needed
  });
});


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

  })
})

describe('User Profile', () => {
  it('should update user profile information', () => {
    cy.visit('http://localhost:3000/user/login');

    // Assuming user is logged in
    cy.get('#email').type('user@example.com');
    cy.get('#password').type('password123');
    cy.get('.MuiButtonBase-root')
        .click()

    cy.visit('http://localhost:3000/userprofile');
    // Click on Edit button
    cy.get('button').contains('Edit').click();

    // Update user profile information
    cy.get('input[name="username"]').clear().type('UpdatedUsername');
    cy.get('input[name="email"]').clear().type('updated@example.com');
    cy.get('input[name="address"]').clear().type('Updated Address');
    cy.get('input[name="birthdate"]').clear().type('1990-01-01');
    cy.get('input[name="password"]').clear().type('UpdatedPassword123');

    // Click on Save button
    cy.get('button').contains('Save').click();

  });
});