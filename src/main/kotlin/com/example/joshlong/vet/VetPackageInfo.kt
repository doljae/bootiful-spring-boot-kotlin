package com.example.joshlong.vet

import org.springframework.modulith.ApplicationModule
import org.springframework.modulith.PackageInfo

@PackageInfo
@ApplicationModule(allowedDependencies = ["dog::internal"])
class VetPackageInfo
