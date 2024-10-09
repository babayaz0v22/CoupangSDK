# SDK for Coupang OPENAPI

ver 1.0.19

[TOC]

## 1. Getting Started

#### 1-1. SDK란 무엇인가요 ?

  SDK(Software Development Kit)에는 Coupang OPEN API를 구현하는 데 필요한 다양한 Class / Method / Sample 등이 포함되어 있습니다. 싱글  Java Library (.jar file)로 특정 클래스 패스에 Import 될 수 있고, 클라이언트 코드에서 사용할 수 있습니다. 풍부한 Sample 데이터를 활용하여 더욱 편리하게 쿠팡 Open API를 개발할 수 있습니다. 

>**SDK 지원 환경**
>
>SDK는 Java 1.7 이상의 버젼을 지원합니다.



#### 1-2. SDK의 장점

  1) SDK를 이용하여 손쉽게 OPEN API 설계할 수 있도록 모든 API에 Sample 코드를 제공합니다.

  2) HMAC 생성을 위한 추가 코드 개발이 필요 없습니다.

  3) JSON 스트링을 사용할 필요 없습니다. 

  4) 다언어를 지원할 예정입니다. (현재는 Java Client만 가능하나, 이후 확장 예정입니다.) 



#### 1-3. SDK 설치 방법

  1) 작업중인 디렉토리에 SDK를 다운받고 압축을 해제합니다.

  2) 각 Sample을 참고하여 API 어플리케이션을 개발합니다.

  3) 컴파일 및 어플리케이션을 실행합니다.



## 2. SDK Sample

#### 2-1. SDK Sample?

SDK Sample을 활용하면, SDK에 포함된 각각의 라이브러리의 활용법을 쉽게 파악할 수 있습니다. 개발하고자 하는 OPEN API가 어떤 파라미터로 구성되어 있는지 한 눈에 볼 수 있으며, 개발에 앞서 빠르게 OPEN API를 호출 및 테스트를 할 수 있습니다.

#### 2-2. Sample 사용법

1) SDK를 다운로드 하고 압축을 풀면, `Sample` 경로에 API 카테고리별로 샘플이 준비되어 있습니다. 테스트할 sample 파일을 선택해주세요.

![SDKsample](https://developers.coupang.com/assets/img/sdk/SDKsample.png)

2) 각 API를 호출하는데 필요한 Log in / Product & item level 정보를  `sample/config/vendor.properties`에 정의할 수 있습니다.

![configsetting](https://developers.coupang.com/assets/img/sdk/config.png)

3) API별 필수 파라미터를 추가로 세팅하고, 샘플파일을 실행합니다. (실제 개발 시에는DB를 직접 연결합니다.)

![samplerun](https://developers.coupang.com/assets/img/sdk/sampler.png)

4) 실행 결과를 확인합니다. 

![createresults](https://developers.coupang.com/assets/img/sdk/Create.png)



#### 2-3. SDK Sample Scope

[개발자 포탈 문서 링크 참조](https://developers.coupang.com/hc/ko/articles/360033878033)



## 3. Javadocs for SDK

SDK Package를 구성하는 Method 관련 안내를 정리한 문서입니다. SDK와 관련된 모든 Javadocs는 다음 URL 에서 확인 가능합니다. 

Coupang SDK Javadocs URL :  https://developers.coupang.com/assets/sdk/javadocs/index.html



## 4. Contact & License 

#### 4-1. Contact

  API 정책 및 Request / Response Message 관련 문의 :  WING -> 온라인문의 항목 이용

  SDK 관련 기술 문의 : [openapisupport@coupang.com](mailto:openapisupport@coupang.com)


#### 4-2. License

Copyright (c) 2019 Coupang Corp.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.