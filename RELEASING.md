# RELEASING

- Ensure java version is greater than or equal to 11
```bash
java --version
```

- Set version variable in terminal shell
```bash
VERSION_NAME="<version name>"
```

- Create a release branch
```bash
git checkout master
git pull
git checkout -b release_"$VERSION_NAME"
```

- Update `VERSION_NAME` (remove `-SNAPSHOT`) and `VERSION_CODE` in root project's `gradle.properties` file

- Update `version` in project's `README.md` documentation

- Update `CHANGELOG.md`

- Commit Changes
```bash
git add --all
git commit -S -m "Prepare $VERSION_NAME release"
git tag -s "$VERSION_NAME" -m "Release v$VERSION_NAME"
```

- Make sure you have valid credentials in `~/.gradle/gradle.properties`
```
mavenCentralUsername=MyUserName
mavenCentralPassword=MyPassword
```

- Make sure you have GPG gradle config setup in `~/.gradle/gradle.properties` for signing
```
signing.keyId=MyGPGKeyId
signing.password=MyGPGKeyPassword
signing.secretKeyRingFile=/path/to/.gnupg/MyGPGKey.gpg
```

- Perform a clean build
```bash
./gradlew clean
./gradlew build --no-build-cache
```

- Publish
```bash
./gradlew publishAllPublicationsToMavenCentralRepository --no-daemon --no-parallel
```

- The [gradle-maven-publish-plugin](https://github.com/vanniktech/gradle-maven-publish-plugin) should have automatically
  closed the staged repositories, but if it did not:
    - Close publications (Don't release yet)
        - LLogin to Central Portal: [central.sonatype.org](https://central.sonatype.com/publishing/deployments)
        - Click on **Staging Repositories**
        - Select all Publications
        - Click **Close** then **Confirm**
        - Wait a bit, hit **Refresh** until the *Status* changes to *Closed*

- **Release** publications from Central Portal UI at [central.sonatype.com](https://central.sonatype.com/publishing/deployments)

- Merge release branch to `master`
```bash
git checkout master
git pull
git merge --no-ff -S release_"$VERSION_NAME"
```

- Update `VERSION_NAME` (add `-SNAPSHOT`) and `VERSION_CODE` in root project's `gradle.properties` file

- Commit changes
```bash
git add --all
git commit -S -m "Prepare for next development iteration"
```

- Push Changes
```bash
git push
```

- Push Tag
```bash
git push origin "$VERSION_NAME"
```

- Delete local release branch
```bash
git branch -D release_"$VERSION_NAME"
```

- Wait for releases to become available on [MavenCentral](https://repo1.maven.org/maven2/org/kotlincrypto/)
- Draft new release on GitHub
    - Enter the release name <VersionName> as tag and title
    - Have the description point to the changelog
