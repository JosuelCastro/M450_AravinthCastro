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
