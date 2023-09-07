module.exports = {
  transform: {
    '^.+\\.ts?$': 'ts-jest'
  },
  testRegex: '(/__tests__/.*|(\\.|/)(test|spec))\\.ts?$',
  moduleFileExtensions: ['ts', 'js', 'json', 'node'],
  collectCoverage: true,
  clearMocks: true,
  collectCoverageFrom: [
    'src/web/app/**/*.ts',
    '!src/web/app/**/*.module.ts',
    'src/web/environments/**/*.ts',
    'src/web/services/**/*.ts',
  ],
  coverageDirectory: './coverage',
  coverageReporters: ['lcov', 'text-summary'],
  setupFiles: [
    './jest-setup.ts',
  ],
  moduleNameMapper: {
    d3: '<rootDir>/node_modules/d3/dist/d3.min.js',
  },
  globalSetup: 'jest-preset-angular/global-setup',
};
