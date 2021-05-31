# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Added
- Publishing to maven central
- Interface FilterExceptionUtil for flexibility, clients can override 
  of logic of handling exceptions

### Changed
- Improve the interop of library code with Java clients

## [1.1.0] - 2021-05-29
### Added
- Bean BotCommandRunner - initializer of bot's commands at the start.

### Changed
- Modules' names
- Packages and groupId

### Removed
- hibernate-validator dependency
- spring-boot-devtools dependency

## [1.0.0] - 2021-05-28
### Added
- Initial release

[Unreleased]: https://github.com/zh-efimenko/telesender/compare/v1.1.0...HEAD
[1.1.0]: https://github.com/zh-efimenko/telesender/releases/tag/v1.1.0
[1.0.0]: https://github.com/zh-efimenko/telesender/releases/tag/v1.0.0
