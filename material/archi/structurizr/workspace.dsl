workspace "Genealogical Graph System" "World's largest genealogical graph platform" {

    !identifiers hierarchical

    model {
        # External actors
        endUser = person "End User" "Millions of users searching and viewing genealogical data" {
            tags "User"
        }
        
        fieldCollector = person "Field Collector" "Teams collecting and verifying historical records in the field" {
            tags "User"
        }
        
        thirdPartyDev = person "Third-Party Developer" "Thousands of developers building applications on the platform" {
            tags "User"
        }
        
        facebookSystem = softwareSystem "Facebook" "Social network for user authentication and profile linking" {
            tags "External"
        }

        # Main system
        genealogySystem = softwareSystem "Genealogical Graph Platform" "World's largest genealogical graph enabling users to view, search, and verify historical records" {
            tags "Target System"
            
            # C4 Level 2: Containers
            webApp = container "Web Application" "Provides genealogy search and browsing capabilities for end users" {
                tags "Container" "Frontend"
                technology "React/TypeScript"
            }
            
            mobileApp = container "Mobile Application" "Native mobile app for iOS/Android for genealogy access" {
                tags "Container" "Frontend"
                technology "React Native"
            }
            
            apiGateway = container "API Gateway" "REST API gateway for third-party access and internal routing" {
                tags "Container" "Integration"
                technology "Node.js/Express"
                
                routingComponent = component "Request Router" "Routes API requests to appropriate backend services" {
                    tags "Component" "Integration"
                    technology "Express Router"
                }
                
                rateLimiter = component "Rate Limiter" "Enforces API rate limits for third-party applications" {
                    tags "Component" "Integration"
                    technology "Node.js Middleware"
                }
                
                authMiddleware = component "Auth Middleware" "Validates JWT tokens and API keys" {
                    tags "Component" "Integration"
                    technology "Passport.js"
                }
            }
            
            graphDB = container "Graph Database" "Stores genealogical relationships and person records" {
                tags "Container" "Database"
                technology "Neo4j"
            }
            
            searchEngine = container "Search Engine" "Full-text search and indexing for genealogical records" {
                tags "Container" "Data Processing"
                technology "Elasticsearch"
            }
            
            recordsService = container "Records Service" "Manages historical records ingestion, verification, and workflow" {
                tags "Container" "Backend"
                technology "Node.js"
                
                ingestComponent = component "Record Ingestion" "Receives and processes historical records from field collectors" {
                    tags "Component" "Backend"
                    technology "Express Controller"
                }
                
                validationComponent = component "Record Validation" "Validates record format and required fields" {
                    tags "Component" "Backend"
                    technology "Node.js"
                }
                
                workflowComponent = component "Workflow Orchestrator" "Manages double verification workflow for records" {
                    tags "Component" "Backend"
                    technology "Node.js"
                }
            }
            
            verificationService = container "Verification Service" "Handles double transcription and verification of historical records" {
                tags "Container" "Backend"
                technology "Node.js"
                
                assignmentComponent = component "Task Assignment" "Assigns verification tasks to field collectors" {
                    tags "Component" "Backend"
                    technology "Express Controller"
                }
                
                comparisonComponent = component "Transcription Comparison" "Compares two transcriptions and handles discrepancies" {
                    tags "Component" "Backend"
                    technology "Node.js"
                }
                
                approvalComponent = component "Approval Engine" "Approves verified records for graph ingestion" {
                    tags "Component" "Backend"
                    technology "Node.js"
                }
            }
            
            authService = container "Authentication Service" "Handles user authentication including Facebook integration" {
                tags "Container" "Backend"
                technology "Node.js/OAuth"
                
                facebookAuth = component "Facebook OAuth Handler" "Handles Facebook login and profile linking" {
                    tags "Component" "Backend"
                    technology "Passport.js"
                }
                
                jwtHandler = component "JWT Token Manager" "Generates and validates JWT tokens" {
                    tags "Component" "Backend"
                    technology "jsonwebtoken"
                }
                
                userRegistry = component "User Registry" "Manages user accounts and permissions" {
                    tags "Component" "Backend"
                    technology "Node.js"
                }
            }
            
            notificationService = container "Notification Service" "Sends notifications about verification tasks and record updates" {
                tags "Container" "Backend"
                technology "Node.js"
            }
            
            messageQueue = container "Message Queue" "Asynchronous processing for record verification workflows" {
                tags "Container" "Data Processing"
                technology "Kafka/RabbitMQ"
            }
            
            cache = container "Cache Layer" "Caches frequently accessed genealogical data for performance" {
                tags "Container" "Cache"
                technology "Redis"
            }
            
            recordsStorage = container "Records Storage" "Stores scanned historical records and images" {
                tags "Container" "Storage"
                technology "S3/Object Storage"
            }

            # Inter-container relationships
            webApp -> apiGateway "Queries genealogical data via"
            mobileApp -> apiGateway "Queries genealogical data via"
            thirdPartyDev -> apiGateway "Calls API endpoints"
            
            apiGateway -> recordsService "Routes record requests to"
            apiGateway -> verificationService "Routes verification requests to"
            apiGateway -> graphDB "Reads genealogical data from"
            apiGateway -> searchEngine "Queries"
            apiGateway -> cache "Checks cache"
            apiGateway -> authService "Validates with"
            
            webApp -> cache "Reads cached data from"
            mobileApp -> cache "Reads cached data from"
            
            recordsService -> recordsStorage "Stores scanned records in"
            recordsService -> messageQueue "Publishes validation events to"
            recordsService -> verificationService "Initiates verification workflow"
            
            verificationService -> recordsStorage "Reads scanned records from"
            verificationService -> graphDB "Writes verified records to"
            verificationService -> searchEngine "Updates search index"
            verificationService -> cache "Invalidates cache"
            verificationService -> messageQueue "Publishes task assignment to"
            
            authService -> facebookSystem "Authenticates with"
            authService -> graphDB "Stores user profiles in"
            
            fieldCollector -> recordsService "Submits historical records to"
            fieldCollector -> verificationService "Verifies records for"
            fieldCollector -> notificationService "Receives notifications from"
            
            messageQueue -> notificationService "Publishes events to"
            messageQueue -> recordsService "Publishes events to"
            
            endUser -> webApp "Uses"
            endUser -> mobileApp "Uses"
        }

        # System relationships
        endUser -> genealogySystem "Searches and browses genealogical records"
        fieldCollector -> genealogySystem "Submits and verifies records"
        thirdPartyDev -> genealogySystem "Integrates with platform API"
        genealogySystem -> facebookSystem "Uses for authentication"
    }

    views {
        # C4 Level 1: System Context
        systemContext genealogySystem "SystemContext" {
            include *
            autolayout lr
        }

        # C4 Level 2: Container Diagram
        container genealogySystem "Containers" {
            include *
            autolayout lr
        }

        # C4 Level 3: Component Diagrams for key services
        component genealogySystem.apiGateway "APIGatewayComponents" {
            include *
            autolayout tb
        }

        component genealogySystem.recordsService "RecordsServiceComponents" {
            include *
            autolayout tb
        }

        component genealogySystem.verificationService "VerificationServiceComponents" {
            include *
            autolayout tb
        }

        component genealogySystem.authService "AuthServiceComponents" {
            include *
            autolayout tb
        }

        styles {
            element "Element" {
                color #ffffff
                background #444444
                fontSize 13
                border solid
            }
            
            element "Person" {
                shape person
                background #08427b
                color #ffffff
            }
            
            element "User" {
                background #08427b
            }
            
            element "Target System" {
                background #1168bd
                color #ffffff
            }
            
            element "External" {
                background #999999
                color #ffffff
            }
            
            element "Container" {
                background #438dd5
                color #ffffff
            }
            
            element "Frontend" {
                background #85bbf0
                color #000000
            }
            
            element "Backend" {
                background #438dd5
                color #ffffff
            }
            
            element "Database" {
                shape cylinder
                background #438dd5
                color #ffffff
            }
            
            element "Cache" {
                shape cylinder
                background #85bbf0
                color #000000
            }
            
            element "Storage" {
                shape folder
                background #85bbf0
                color #000000
            }
            
            element "Integration" {
                background #a8c5dd
                color #000000
            }
            
            element "Data Processing" {
                background #a8c5dd
                color #000000
            }
            
            element "Component" {
                background #85bbf0
                color #000000
                fontSize 11
            }
            
            relationship "Relationship" {
                thickness 2
                fontSize 10
            }
        }

        branding {
            logo https://example.com/logo.png
        }
    }

}