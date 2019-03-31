# Open Angular Console Here
An IntelliJ plugin for opening current directory in Angular Console.

## Usage
Right click on target file or directory in Project view, then select **Open Angular Console Here**.

## Compatibility
**Mac** and **Win** platforms are supported temporarily.

## Shortcut Key
* Mac: **option** + A
* Win: **alt** + A

## Development

Verify plugin:
```bash
gradle verifyPlugin
```

Build plugin and zip file will be located at `build/distributions`: 
```bash
gradle buildPlugin
```

Run Intellij IDEA with plugin installed:
```bash
gradle runIde
```

Publish plugin:
```bash
gradle publishPlugin -Dorg.gradle.project.intellijPublishToken="<token>"
```
**NOTE: Ensure credentials are passed in as mentioned in [deployment documentation](https://www.jetbrains.org/intellij/sdk/docs/tutorials/build_system/deployment.html)**


## References
- OpenTerminalHere [plugin](https://plugins.jetbrains.com/plugin/8081-open-terminal-here) | [source](https://github.com/hzio/OpenTerminalHere)  
- [Jetbrains IntelliJ SDK Documentation](http://www.jetbrains.org/intellij/sdk/docs/welcome.html)
- [Angular Console](https://github.com/nrwl/angular-console)
- Angular Console under the covers URL route that Electron uses to directly view project
  ```
  http://localhost:7777/workspace/<url-encoded-absolute-path-to-project>/
  ```
